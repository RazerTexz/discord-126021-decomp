package com.discord.stores;

import com.discord.api.commands.ApplicationCommandType;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.commands.BuiltInCommand;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.m;
import d0.t.n;
import java.util.List;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInCommands implements BuiltInCommandsProvider {
    public static final long BUILT_IN_APP_ID = -1;
    public static final BuiltInCommands$Companion Companion = new BuiltInCommands$Companion(null);
    public static final long FRECENCY_APP_ID = -2;
    private final Application builtInApplication;
    private final List<ApplicationCommand> builtInCommands;

    public BuiltInCommands() {
        List<ApplicationCommand> listListOf = n.listOf((Object[]) new ApplicationCommand[]{createAppendToEndSlashCommand(-1L, "shrug", 2131887746, 2131887747, "¯\\\\_(ツ)\\_/¯"), createAppendToEndSlashCommand(-2L, "tableflip", 2131887750, 2131887751, "(╯°□°）╯︵ ┻━┻"), createAppendToEndSlashCommand(-3L, "unflip", 2131887752, 2131887753, "┬─┬ ノ( ゜-゜ノ)"), createWrappedSlashCommand(-5L, "me", 2131887733, 2131887734, "_"), createWrappedSlashCommand(-6L, "spoiler", 2131887748, 2131887749, "||")});
        this.builtInCommands = listListOf;
        this.builtInApplication = new Application(-1L, "Built-In", null, 2131232129, listListOf.size(), null, true, 36, null);
    }

    private final ApplicationCommand createAppendToEndSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String replacement) {
        return new BuiltInCommand(String.valueOf(id2), -1L, name, descriptionRes, m.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, false, false, null, null, null, false, null, null, 4036, null)), new BuiltInCommands$createAppendToEndSlashCommand$1(replacement));
    }

    private final ApplicationCommand createWrappedSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String wrapper) {
        return new BuiltInCommand(String.valueOf(id2), -1L, name, descriptionRes, m.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, true, false, null, null, null, false, null, null, 4036, null)), new BuiltInCommands$createWrappedSlashCommand$1(wrapper));
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public Application getBuiltInApplication() {
        return this.builtInApplication;
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public List<ApplicationCommand> getBuiltInCommands() {
        return this.builtInCommands;
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public Application getFrecencyApplication() {
        return new Application(-2L, "Frequently Used", null, 2131232079, 0, null, true, 36, null);
    }
}
