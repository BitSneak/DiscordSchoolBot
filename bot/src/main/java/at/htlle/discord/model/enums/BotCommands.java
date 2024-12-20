package at.htlle.discord.model.enums;

import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
public enum BotCommands {
    ADD_CLASS_TEACHER(
            "add",
            "class-teacher",
            "Add a class teacher",
            List.of(new CommandOption("abbreviation", "The abbreviation of the class teacher", true))),
    ADD_CLASS(
            "add",
            "class",
            "Add a class",
            List.of(
                    new CommandOption("class", "The name of the class", true),
                    new CommandOption("teacher-abbreviation", "The abbreviation of the class teacher", true)
            )),
    ROTATE("rotate", "Rotate the classes one year forward");

    private final String command;
    private final String subcommand;
    private final String description;
    private final List<CommandOption> options;

    BotCommands(String command, String description) {
        this(command, null, description, Collections.emptyList());
    }

    BotCommands(String command, String subcommand, String description) {
        this(command, subcommand, description, Collections.emptyList());
    }

    BotCommands (String command, String subcommand, String description, List<CommandOption> options) {
        this.command = command;
        this.subcommand = subcommand;
        this.description = description;
        this.options = options;
    }

    public boolean matches(String command, String subcommand) {
        return this.command.equals(command) &&
                (this.subcommand == null || this.subcommand.equals(subcommand));
    }

    public record CommandOption(String name, String description, boolean required) {
    }
}