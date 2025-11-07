package meteordevelopment.meteorclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.misc.PanicState;
import net.minecraft.command.CommandSource;

public class PanicCommand extends Command {
    public PanicCommand() {
        super("panic", "Włącza tryb panic. Czyszczenie logów nastąpi automatycznie w głównym wątku Meteora.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            PanicState.setPanicMode(true); // <-- tutaj tylko ustawiamy flagę
            return SINGLE_SUCCESS;
        });
    }
}
