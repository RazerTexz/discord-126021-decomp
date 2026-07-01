package com.discord.stores;

import android.content.res.Resources;
import com.discord.R;
import com.discord.api.commands.ApplicationCommandPermission;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand3;
import com.discord.models.commands.ApplicationCommand5;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommandsKt {
    private static final ApplicationCommand3 expandSubCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption) {
        String name = applicationCommandOption.getName();
        long applicationId = applicationCommand.getApplicationId();
        String str = applicationCommand.getName() + " " + applicationCommandOption.getName();
        String description = applicationCommandOption.getDescription();
        List<ApplicationCommandOption> options = applicationCommandOption.getOptions();
        if (options == null) {
            options = Collections2.emptyList();
        }
        return new ApplicationCommand3(applicationCommand, name, null, applicationId, str, description, null, options, applicationCommand.getGuildId(), null, null, applicationCommand.getVersion(), 1604, null);
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
                        options2 = Collections2.emptyList();
                    }
                    arrayList.add(new ApplicationCommand3(applicationCommand, name, name2, applicationId, str, description, null, options2, applicationCommand.getGuildId(), null, null, applicationCommand.getVersion(), 1600, null));
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
        Intrinsics3.checkNotNullParameter(list, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        for (ApplicationCommandValue applicationCommandValue : list) {
            arrayList.add(applicationCommandValue);
            if (applicationCommandValue.getType() == ApplicationCommandType.SUBCOMMAND.getType()) {
                List<ApplicationCommandValue> options2 = applicationCommandValue.getOptions();
                if (options2 == null) {
                    options2 = Collections2.emptyList();
                }
                arrayList.addAll(options2);
            } else if (applicationCommandValue.getType() == ApplicationCommandType.SUBCOMMAND_GROUP.getType() && (options = applicationCommandValue.getOptions()) != null) {
                Iterator<T> it = options.iterator();
                while (it.hasNext()) {
                    List<ApplicationCommandValue> options3 = ((ApplicationCommandValue) it.next()).getOptions();
                    if (options3 == null) {
                        options3 = Collections2.emptyList();
                    }
                    arrayList.addAll(options3);
                }
            }
        }
        return arrayList;
    }

    public static final List<ApplicationCommand> flattenSubCommands(List<? extends ApplicationCommand> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$flattenSubCommands");
        ArrayList arrayList = new ArrayList();
        for (ApplicationCommand applicationCommand : list) {
            if (applicationCommand instanceof ApplicationCommand5) {
                arrayList.addAll(expandSubCommands(applicationCommand));
            } else {
                arrayList.add(applicationCommand);
            }
        }
        return arrayList;
    }

    public static final String getDescriptionText(ApplicationCommand applicationCommand, Resources resources) {
        Intrinsics3.checkNotNullParameter(applicationCommand, "$this$getDescriptionText");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        Integer descriptionRes = applicationCommand.getDescriptionRes();
        if (descriptionRes != null) {
            String string = resources.getString(descriptionRes.intValue());
            Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(it)");
            String strReplace$default = StringsJVM.replace$default(string, "¯_(ツ)_/¯", "¯\\_(ツ)_/¯", false, 4, (Object) null);
            if (strReplace$default != null) {
                return strReplace$default;
            }
        }
        return applicationCommand.getDescription();
    }

    public static final String getErrorText(ApplicationCommandOption applicationCommandOption, Resources resources) {
        Intrinsics3.checkNotNullParameter(applicationCommandOption, "$this$getErrorText");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        if (applicationCommandOption.getType() == ApplicationCommandType.STRING) {
            List<CommandChoice> choices = applicationCommandOption.getChoices();
            if (!(choices == null || choices.isEmpty())) {
                return resources.getString(R.string.command_validation_choice_error);
            }
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.INTEGER) {
            return resources.getString(R.string.command_validation_integer_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.NUMBER) {
            return resources.getString(R.string.command_validation_number_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.BOOLEAN) {
            return resources.getString(R.string.command_validation_boolean_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.USER) {
            return resources.getString(R.string.command_validation_user_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.CHANNEL) {
            return resources.getString(R.string.command_validation_channel_error);
        }
        if (applicationCommandOption.getType() == ApplicationCommandType.ROLE) {
            return resources.getString(R.string.command_validation_role_error);
        }
        return applicationCommandOption.getType() == ApplicationCommandType.MENTIONABLE ? resources.getString(R.string.command_validation_mentionable_error) : resources.getString(R.string.command_validation_required_error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<ApplicationCommandValue> mapApplicationCommandValues(List<ApplicationCommandValue> list, Function1<? super ApplicationCommandValue, ApplicationCommandValue> function1) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Intrinsics3.checkNotNullParameter(list, "$this$mapApplicationCommandValues");
        Intrinsics3.checkNotNullParameter(function1, "mappingFunction");
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (ApplicationCommandValue applicationCommandValueCopy$default : list) {
            ArrayList arrayList4 = null;
            if (applicationCommandValueCopy$default.getType() == ApplicationCommandType.SUBCOMMAND.getType()) {
                List<ApplicationCommandValue> options = applicationCommandValueCopy$default.getOptions();
                if (options != null) {
                    arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(options, 10));
                    Iterator<T> it = options.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(function1.invoke(it.next()));
                    }
                }
                applicationCommandValueCopy$default = ApplicationCommandValue.copy$default(applicationCommandValueCopy$default, null, null, 0, arrayList4, null, 23, null);
            } else if (applicationCommandValueCopy$default.getType() == ApplicationCommandType.SUBCOMMAND_GROUP.getType()) {
                List<ApplicationCommandValue> options2 = applicationCommandValueCopy$default.getOptions();
                if (options2 != null) {
                    ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(options2, 10));
                    for (ApplicationCommandValue applicationCommandValue : options2) {
                        List<ApplicationCommandValue> options3 = applicationCommandValue.getOptions();
                        if (options3 != null) {
                            ArrayList arrayList6 = new ArrayList(Iterables2.collectionSizeOrDefault(options3, 10));
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
        Intrinsics3.checkNotNullParameter(application, "$this$toDomainApplication");
        return new Application(application.getId(), application.getName(), application.getIcon(), null, application.getCommandCount(), application.getBot(), false, 72, null);
    }

    public static final List<ApplicationCommand> toDomainCommands(List<com.discord.api.commands.ApplicationCommand> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$toDomainCommands");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toSlashCommand((com.discord.api.commands.ApplicationCommand) it.next()));
        }
        return arrayList;
    }

    public static final ApplicationCommand toSlashCommand(com.discord.api.commands.ApplicationCommand applicationCommand) {
        List listEmptyList;
        Intrinsics3.checkNotNullParameter(applicationCommand, "$this$toSlashCommand");
        String strValueOf = String.valueOf(applicationCommand.getId());
        long applicationId = applicationCommand.getApplicationId();
        String name = applicationCommand.getName();
        String description = applicationCommand.getDescription();
        List<com.discord.api.commands.ApplicationCommandOption> listG = applicationCommand.g();
        if (listG != null) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listG, 10));
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                arrayList.add(toSlashCommandOption((com.discord.api.commands.ApplicationCommandOption) it.next()));
            }
            listEmptyList = arrayList;
        } else {
            listEmptyList = Collections2.emptyList();
        }
        String version = applicationCommand.getVersion();
        List<ApplicationCommandPermission> listH = applicationCommand.h();
        Boolean defaultPermissions = applicationCommand.getDefaultPermissions();
        String guildId = applicationCommand.getGuildId();
        return new ApplicationCommand5(strValueOf, applicationId, name, description, listEmptyList, guildId != null ? Long.valueOf(Long.parseLong(guildId)) : null, version, defaultPermissions, listH, null, 512, null);
    }

    public static final ApplicationCommandOption toSlashCommandOption(com.discord.api.commands.ApplicationCommandOption applicationCommandOption) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(applicationCommandOption, "$this$toSlashCommandOption");
        ApplicationCommandType type = applicationCommandOption.getType();
        String name = applicationCommandOption.getName();
        String description = applicationCommandOption.getDescription();
        boolean required = applicationCommandOption.getRequired();
        boolean z2 = applicationCommandOption.getDefault();
        List<CommandChoice> listC = applicationCommandOption.c();
        List<Integer> listB = applicationCommandOption.b();
        Number minValue = applicationCommandOption.getMinValue();
        Number maxValue = applicationCommandOption.getMaxValue();
        List<com.discord.api.commands.ApplicationCommandOption> listI = applicationCommandOption.i();
        if (listI != null) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listI, 10));
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                arrayList2.add(toSlashCommandOption((com.discord.api.commands.ApplicationCommandOption) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new ApplicationCommandOption(type, name, description, null, required, z2, listB, listC, arrayList, applicationCommandOption.getAutocomplete(), minValue, maxValue, 8, null);
    }

    public static final String getDescriptionText(ApplicationCommandOption applicationCommandOption, Resources resources) {
        String string;
        Intrinsics3.checkNotNullParameter(applicationCommandOption, "$this$getDescriptionText");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        Integer descriptionRes = applicationCommandOption.getDescriptionRes();
        return (descriptionRes == null || (string = resources.getString(descriptionRes.intValue())) == null) ? applicationCommandOption.getDescription() : string;
    }
}
