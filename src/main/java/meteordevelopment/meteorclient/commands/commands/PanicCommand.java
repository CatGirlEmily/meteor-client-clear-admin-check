package meteordevelopment.meteorclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.misc.PanicState;
import net.minecraft.command.CommandSource;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class PanicCommand extends Command {
    public PanicCommand() {
        super("panic", "Usuwa wszystkie linie zawierające 'meteor' z logs/latest.log i ukrywa GUI Meteora.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            cleanLogs("meteor");
            PanicState.setPanicMode(true); // <-- Tryb panic aktywowany
            return SINGLE_SUCCESS;
        });
    }

    private void cleanLogs(String keyword) {
        Path logPath = Paths.get("logs/latest.log");
        try {
            if (!Files.exists(logPath)) return;

            List<String> lines = Files.readAllLines(logPath);
            List<String> filtered = lines.stream()
                    .filter(line -> !line.toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());

            Files.write(logPath, filtered, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        } catch (IOException ignored) {}
    }
}
