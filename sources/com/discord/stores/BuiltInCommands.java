package com.discord.stores;

import com.discord.C5419R;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.commands.BuiltInCommand;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInCommands implements BuiltInCommandsProvider {
    public static final long BUILT_IN_APP_ID = -1;
    public static final long FRECENCY_APP_ID = -2;
    private final Application builtInApplication;
    private final List<ApplicationCommand> builtInCommands;

    /* JADX INFO: renamed from: com.discord.stores.BuiltInCommands$createAppendToEndSlashCommand$1 */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class C56621 extends AbstractC12240o implements Function1<Map<String, ? extends Object>, String> {
        public final /* synthetic */ String $replacement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56621(String str) {
            super(1);
            this.$replacement = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Map<String, ? extends Object> map) {
            C12238m.checkNotNullParameter(map, "commandOptions");
            StringBuilder sb = new StringBuilder();
            Object obj = map.get("message");
            if (obj == null) {
                obj = "";
            }
            sb.append(obj);
            sb.append(' ');
            sb.append(this.$replacement);
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.BuiltInCommands$createWrappedSlashCommand$1 */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class C56631 extends AbstractC12240o implements Function1<Map<String, ? extends Object>, String> {
        public final /* synthetic */ String $wrapper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56631(String str) {
            super(1);
            this.$wrapper = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Map<String, ? extends Object> map) {
            C12238m.checkNotNullParameter(map, "commandOptions");
            StringBuilder sb = new StringBuilder();
            sb.append(this.$wrapper);
            Object obj = map.get("message");
            if (obj == null) {
                obj = "";
            }
            sb.append(obj);
            sb.append(this.$wrapper);
            return sb.toString();
        }
    }

    public BuiltInCommands() {
        List<ApplicationCommand> listListOf = C12147n.listOf((Object[]) new ApplicationCommand[]{createAppendToEndSlashCommand(-1L, "shrug", Integer.valueOf(C5419R.string.command_shrug_description), Integer.valueOf(C5419R.string.command_shrug_message_description), "¯\\\\_(ツ)\\_/¯"), createAppendToEndSlashCommand(-2L, "tableflip", Integer.valueOf(C5419R.string.command_tableflip_description), Integer.valueOf(C5419R.string.command_tableflip_message_description), "(╯°□°）╯︵ ┻━┻"), createAppendToEndSlashCommand(-3L, "unflip", Integer.valueOf(C5419R.string.command_tableunflip_description), Integer.valueOf(C5419R.string.command_tableunflip_message_description), "┬─┬ ノ( ゜-゜ノ)"), createWrappedSlashCommand(-5L, "me", Integer.valueOf(C5419R.string.command_me_description), Integer.valueOf(C5419R.string.command_me_message_description), "_"), createWrappedSlashCommand(-6L, "spoiler", Integer.valueOf(C5419R.string.command_spoiler_description), Integer.valueOf(C5419R.string.command_spoiler_message_description), "||")});
        this.builtInCommands = listListOf;
        this.builtInApplication = new Application(-1L, "Built-In", null, Integer.valueOf(C5419R.drawable.ic_slash_command_24dp), listListOf.size(), null, true, 36, null);
    }

    private final ApplicationCommand createAppendToEndSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String replacement) {
        return new BuiltInCommand(String.valueOf(id2), -1L, name, descriptionRes, C12145m.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, false, false, null, null, null, false, null, null, 4036, null)), new C56621(replacement));
    }

    private final ApplicationCommand createWrappedSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String wrapper) {
        return new BuiltInCommand(String.valueOf(id2), -1L, name, descriptionRes, C12145m.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, true, false, null, null, null, false, null, null, 4036, null)), new C56631(wrapper));
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
        return new Application(-2L, "Frequently Used", null, Integer.valueOf(C5419R.drawable.ic_recent_24dp), 0, null, true, 36, null);
    }
}
