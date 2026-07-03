package com.discord.stores;

import android.content.res.Resources;
import com.discord.C5419R;
import com.discord.api.commands.ApplicationCommandPermission;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.commands.ApplicationSubCommand;
import com.discord.models.commands.RemoteApplicationCommand;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommandsKt {
    private static final ApplicationSubCommand expandSubCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption) {
        String name = applicationCommandOption.getName();
        long applicationId = applicationCommand.getApplicationId();
        String str = applicationCommand.getName() + " " + applicationCommandOption.getName();
        String description = applicationCommandOption.getDescription();
        List<ApplicationCommandOption> options = applicationCommandOption.getOptions();
        if (options == null) {
            options = C12147n.emptyList();
        }
        return new ApplicationSubCommand(applicationCommand, name, null, applicationId, str, description, null, options, applicationCommand.getGuildId(), null, null, applicationCommand.getVersion(), 1604, null);
    }

    private static final List<ApplicationCommand> expandSubCommandGroup(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption) {
        ArrayList arrayList = new ArrayList();
        List<ApplicationCommandOption> options = applicationCommandOption.getOptions();
        if (options != null) {
            for (ApplicationCommandOption applicationCommandOption2 : options) {
                if (applicationCommandOption2.getType() == ApplicationCommandType.SUBCOMMAND) {
                    String name = applicationCommandOption2.getName();
                    String name2 = applicationCommandOption.getName();
                    long applicationId = applicationCommand.getApplicationId();
                    String str = applicationCommand.getName() + " " + applicationCommandOption.getName() + " " + applicationCommandOption2.getName();
                    String description = applicationCommandOption2.getDescription();
                    List<ApplicationCommandOption> options2 = applicationCommandOption2.getOptions();
                    if (options2 == null) {
                        options2 = C12147n.emptyList();
                    }
                    arrayList.add(new ApplicationSubCommand(applicationCommand, name, name2, applicationId, str, description, null, options2, applicationCommand.getGuildId(), null, null, applicationCommand.getVersion(), 1600, null));
                }
            }
        }
        return arrayList;
    }

    private static final List<ApplicationCommand> expandSubCommands(ApplicationCommand applicationCommand) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (ApplicationCommandOption applicationCommandOption : applicationCommand.getOptions()) {
            if (applicationCommandOption.getType() == ApplicationCommandType.SUBCOMMAND) {
                arrayList.add(expandSubCommand(applicationCommand, applicationCommandOption));
            } else if (applicationCommandOption.getType() == ApplicationCommandType.SUBCOMMAND_GROUP) {
                arrayList.addAll(expandSubCommandGroup(applicationCommand, applicationCommandOption));
            }
            z2 = true;
        }
        if (!z2) {
            arrayList.add(applicationCommand);
        }
        return arrayList;
    }

    public static final List<ApplicationCommandValue> flatten(List<ApplicationCommandValue> list) {
        List<ApplicationCommandValue> options;
        C12238m.checkNotNullParameter(list, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        for (ApplicationCommandValue applicationCommandValue : list) {
            arrayList.add(applicationCommandValue);
            if (applicationCommandValue.getType() == ApplicationCommandType.SUBCOMMAND.getType()) {
                List<ApplicationCommandValue> options2 = applicationCommandValue.getOptions();
                if (options2 == null) {
                    options2 = C12147n.emptyList();
                }
                arrayList.addAll(options2);
            } else if (applicationCommandValue.getType() == ApplicationCommandType.SUBCOMMAND_GROUP.getType() && (options = applicationCommandValue.getOptions()) != null) {
                Iterator<T> it = options.iterator();
                while (it.hasNext()) {
                    List<ApplicationCommandValue> options3 = ((ApplicationCommandValue) it.next()).getOptions();
                    if (options3 == null) {
                        options3 = C12147n.emptyList();
                    }
                    arrayList.addAll(options3);
                }
            }
        }
        return arrayList;
    }

    public static final List<ApplicationCommand> flattenSubCommands(List<? extends ApplicationCommand> list) {
        C12238m.checkNotNullParameter(list, "$this$flattenSubCommands");
        ArrayList arrayList = new ArrayList();
        for (ApplicationCommand applicationCommand : list) {
            if (applicationCommand instanceof RemoteApplicationCommand) {
                arrayList.addAll(expandSubCommands(applicationCommand));
            } else {
                arrayList.add(applicationCommand);
            }
        }
        return arrayList;
    }

    public static final String getDescriptionText(ApplicationCommand applicationCommand, Resources resources) {
        C12238m.checkNotNullParameter(applicationCommand, "$this$getDescriptionText");
        C12238m.checkNotNullParameter(resources, "resources");
        Integer descriptionRes = applicationCommand.getDescriptionRes();
        if (descriptionRes != null) {
            String string = resources.getString(descriptionRes.intValue());
            C12238m.checkNotNullExpressionValue(string, "resources.getString(it)");
            String strReplace$default = C12103t.replace$default(string, "¯_(ツ)_/¯", "¯\\_(ツ)_/¯", false, 4, (Object) null);
            if (strReplace$default != null) {
                return strReplace$default;
            }
        }
        return applicationCommand.getDescription();
    }

    public static final String getErrorText(ApplicationCommandOption applicationCommandOption, Resources resources) {
        C12238m.checkNotNullParameter(applicationCommandOption, "$this$getErrorText");
        C12238m.checkNotNullParameter(resources, "resources");
        if (applicationCommandOption.getType() == ApplicationCommandType.STRING) {
            List<CommandChoice> choices = applicationCommandOption.getChoices();
            if (!(choices == null || choices.isEmpty())) {
                return resources.getString(C5419R.string.command_validation_choice_error);
            }
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.INTEGER) {
            return resources.getString(C5419R.string.command_validation_integer_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.NUMBER) {
            return resources.getString(C5419R.string.command_validation_number_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.BOOLEAN) {
            return resources.getString(C5419R.string.command_validation_boolean_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.USER) {
            return resources.getString(C5419R.string.command_validation_user_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.CHANNEL) {
            return resources.getString(C5419R.string.command_validation_channel_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.ROLE) {
            return resources.getString(C5419R.string.command_validation_role_error);
        }
        return applicationCommandOption.getType() == ApplicationCommandType.MENTIONABLE ? resources.getString(C5419R.string.command_validation_mentionable_error) : resources.getString(C5419R.string.command_validation_required_error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<ApplicationCommandValue> mapApplicationCommandValues(List<ApplicationCommandValue> list, Function1<? super ApplicationCommandValue, ApplicationCommandValue> function1) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C12238m.checkNotNullParameter(list, "$this$mapApplicationCommandValues");
        C12238m.checkNotNullParameter(function1, "mappingFunction");
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        for (ApplicationCommandValue applicationCommandValueCopy$default : list) {
            ArrayList arrayList4 = null;
            if (applicationCommandValueCopy$default.getType() == ApplicationCommandType.SUBCOMMAND.getType()) {
                List<ApplicationCommandValue> options = applicationCommandValueCopy$default.getOptions();
                if (options != null) {
                    arrayList4 = new ArrayList(C12149o.collectionSizeOrDefault(options, 10));
                    Iterator<T> it = options.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(function1.invoke(it.next()));
                    }
                }
                applicationCommandValueCopy$default = ApplicationCommandValue.copy$default(applicationCommandValueCopy$default, null, null, 0, arrayList4, null, 23, null);
            } else if (applicationCommandValueCopy$default.getType() == ApplicationCommandType.SUBCOMMAND_GROUP.getType()) {
                List<ApplicationCommandValue> options2 = applicationCommandValueCopy$default.getOptions();
                if (options2 != null) {
                    ArrayList arrayList5 = new ArrayList(C12149o.collectionSizeOrDefault(options2, 10));
                    for (ApplicationCommandValue applicationCommandValue : options2) {
                        List<ApplicationCommandValue> options3 = applicationCommandValue.getOptions();
                        if (options3 != null) {
                            ArrayList arrayList6 = new ArrayList(C12149o.collectionSizeOrDefault(options3, 10));
                            Iterator<T> it2 = options3.iterator();
                            while (it2.hasNext()) {
                                arrayList6.add(function1.invoke(it2.next()));
                            }
                            arrayList2 = arrayList6;
                        } else {
                            arrayList2 = null;
                        }
                        arrayList5.add(function1.invoke(ApplicationCommandValue.copy$default(applicationCommandValue, null, null, 0, arrayList2, null, 23, null)));
                    }
                    arrayList = arrayList5;
                } else {
                    arrayList = null;
                }
                applicationCommandValueCopy$default = ApplicationCommandValue.copy$default(applicationCommandValueCopy$default, null, null, 0, arrayList, null, 23, null);
            }
            arrayList3.add(function1.invoke(applicationCommandValueCopy$default));
        }
        return arrayList3;
    }

    public static final Application toDomainApplication(com.discord.api.commands.Application application) {
        C12238m.checkNotNullParameter(application, "$this$toDomainApplication");
        return new Application(application.getId(), application.getName(), application.getIcon(), null, application.getCommandCount(), application.getBot(), false, 72, null);
    }

    public static final List<ApplicationCommand> toDomainCommands(List<com.discord.api.commands.ApplicationCommand> list) {
        C12238m.checkNotNullParameter(list, "$this$toDomainCommands");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toSlashCommand((com.discord.api.commands.ApplicationCommand) it.next()));
        }
        return arrayList;
    }

    public static final ApplicationCommand toSlashCommand(com.discord.api.commands.ApplicationCommand applicationCommand) {
        List listEmptyList;
        C12238m.checkNotNullParameter(applicationCommand, "$this$toSlashCommand");
        String strValueOf = String.valueOf(applicationCommand.getId());
        long applicationId = applicationCommand.getApplicationId();
        String name = applicationCommand.getName();
        String description = applicationCommand.getDescription();
        List<com.discord.api.commands.ApplicationCommandOption> listM7717g = applicationCommand.m7717g();
        if (listM7717g != null) {
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7717g, 10));
            Iterator<T> it = listM7717g.iterator();
            while (it.hasNext()) {
                arrayList.add(toSlashCommandOption((com.discord.api.commands.ApplicationCommandOption) it.next()));
            }
            listEmptyList = arrayList;
        } else {
            listEmptyList = C12147n.emptyList();
        }
        String version = applicationCommand.getVersion();
        List<ApplicationCommandPermission> listM7718h = applicationCommand.m7718h();
        Boolean defaultPermissions = applicationCommand.getDefaultPermissions();
        String guildId = applicationCommand.getGuildId();
        return new RemoteApplicationCommand(strValueOf, applicationId, name, description, listEmptyList, guildId != null ? Long.valueOf(Long.parseLong(guildId)) : null, version, defaultPermissions, listM7718h, null, 512, null);
    }

    public static final ApplicationCommandOption toSlashCommandOption(com.discord.api.commands.ApplicationCommandOption applicationCommandOption) {
        ArrayList arrayList;
        C12238m.checkNotNullParameter(applicationCommandOption, "$this$toSlashCommandOption");
        ApplicationCommandType type = applicationCommandOption.getType();
        String name = applicationCommandOption.getName();
        String description = applicationCommandOption.getDescription();
        boolean required = applicationCommandOption.getRequired();
        boolean z2 = applicationCommandOption.getDefault();
        List<CommandChoice> listM7728c = applicationCommandOption.m7728c();
        List<Integer> listM7727b = applicationCommandOption.m7727b();
        Number minValue = applicationCommandOption.getMinValue();
        Number maxValue = applicationCommandOption.getMaxValue();
        List<com.discord.api.commands.ApplicationCommandOption> listM7734i = applicationCommandOption.m7734i();
        if (listM7734i != null) {
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(listM7734i, 10));
            Iterator<T> it = listM7734i.iterator();
            while (it.hasNext()) {
                arrayList2.add(toSlashCommandOption((com.discord.api.commands.ApplicationCommandOption) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new ApplicationCommandOption(type, name, description, null, required, z2, listM7727b, listM7728c, arrayList, applicationCommandOption.getAutocomplete(), minValue, maxValue, 8, null);
    }

    public static final String getDescriptionText(ApplicationCommandOption applicationCommandOption, Resources resources) {
        String string;
        C12238m.checkNotNullParameter(applicationCommandOption, "$this$getDescriptionText");
        C12238m.checkNotNullParameter(resources, "resources");
        Integer descriptionRes = applicationCommandOption.getDescriptionRes();
        return (descriptionRes == null || (string = resources.getString(descriptionRes.intValue())) == null) ? applicationCommandOption.getDescription() : string;
    }
}
