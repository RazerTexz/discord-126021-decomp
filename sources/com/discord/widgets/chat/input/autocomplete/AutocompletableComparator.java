package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.ChannelUtils;
import com.discord.models.commands.Application;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Comparator;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompletableComparator implements Comparator<Autocompletable> {
    @Override // java.util.Comparator
    public int compare(Autocompletable o1, Autocompletable o2) {
        Intrinsics3.checkNotNullParameter(o1, "o1");
        Intrinsics3.checkNotNullParameter(o2, "o2");
        if (!Intrinsics3.areEqual(Reflection2.getOrCreateKotlinClass(o1.getClass()), Reflection2.getOrCreateKotlinClass(o2.getClass()))) {
            return Intrinsics3.compare(AutocompletableKt.getSortIndex(o1), AutocompletableKt.getSortIndex(o2));
        }
        if (o1 instanceof ApplicationCommandChoiceAutocompletable) {
            return AutocompletableKt.lower(((ApplicationCommandChoiceAutocompletable) o1).getChoice().getName()).compareTo(AutocompletableKt.lower(((ApplicationCommandChoiceAutocompletable) o2).getChoice().getName()));
        }
        if (o1 instanceof ApplicationCommandLoadingPlaceholder) {
            return 0;
        }
        if (o1 instanceof ApplicationCommandAutocompletable) {
            ApplicationCommandAutocompletable applicationCommandAutocompletable = (ApplicationCommandAutocompletable) o2;
            ApplicationCommandAutocompletable applicationCommandAutocompletable2 = (ApplicationCommandAutocompletable) o1;
            Application application = applicationCommandAutocompletable2.getApplication();
            Long lValueOf = application != null ? Long.valueOf(application.getId()) : null;
            Application application2 = applicationCommandAutocompletable.getApplication();
            if (Intrinsics3.areEqual(lValueOf, application2 != null ? Long.valueOf(application2.getId()) : null)) {
                return AutocompletableKt.lower(applicationCommandAutocompletable2.getCommand().getName()).compareTo(AutocompletableKt.lower(applicationCommandAutocompletable.getCommand().getName()));
            }
            Application application3 = applicationCommandAutocompletable2.getApplication();
            String strLower = AutocompletableKt.lower(String.valueOf(application3 != null ? application3.getName() : null));
            Application application4 = applicationCommandAutocompletable.getApplication();
            return strLower.compareTo(AutocompletableKt.lower(String.valueOf(application4 != null ? application4.getName() : null)));
        }
        if (o1 instanceof ApplicationPlaceholder) {
            return AutocompletableKt.lower(((ApplicationPlaceholder) o1).getApplication().getName()).compareTo(AutocompletableKt.lower(((ApplicationPlaceholder) o2).getApplication().getName()));
        }
        if (o1 instanceof ChannelAutocompletable) {
            ChannelAutocompletable channelAutocompletable = (ChannelAutocompletable) o2;
            ChannelAutocompletable channelAutocompletable2 = (ChannelAutocompletable) o1;
            String strLower2 = AutocompletableKt.lower(ChannelUtils.c(channelAutocompletable2.getChannel()));
            String strLower3 = AutocompletableKt.lower(ChannelUtils.c(channelAutocompletable.getChannel()));
            return Intrinsics3.areEqual(strLower2, strLower3) ^ true ? strLower2.compareTo(strLower3) : (channelAutocompletable2.getChannel().getId() > channelAutocompletable.getChannel().getId() ? 1 : (channelAutocompletable2.getChannel().getId() == channelAutocompletable.getChannel().getId() ? 0 : -1));
        }
        if (o1 instanceof EmojiAutocompletable) {
            String firstName = ((EmojiAutocompletable) o1).getEmoji().getFirstName();
            Intrinsics3.checkNotNullExpressionValue(firstName, "o1.emoji.firstName");
            String strLower4 = AutocompletableKt.lower(firstName);
            String firstName2 = ((EmojiAutocompletable) o2).getEmoji().getFirstName();
            Intrinsics3.checkNotNullExpressionValue(firstName2, "o2c.emoji.firstName");
            return strLower4.compareTo(AutocompletableKt.lower(firstName2));
        }
        if (o1 instanceof EmojiUpsellPlaceholder) {
            return 0;
        }
        if (o1 instanceof GlobalRoleAutocompletable) {
            return AutocompletableKt.lower(((GlobalRoleAutocompletable) o1).getText()).compareTo(AutocompletableKt.lower(((GlobalRoleAutocompletable) o2).getText()));
        }
        if (o1 instanceof RoleAutocompletable) {
            return AutocompletableKt.lower(((RoleAutocompletable) o1).getRole().getName()).compareTo(AutocompletableKt.lower(((RoleAutocompletable) o2).getRole().getName()));
        }
        if (!(o1 instanceof UserAutocompletable)) {
            throw new NoWhenBranchMatchedException();
        }
        UserAutocompletable userAutocompletable = (UserAutocompletable) o1;
        String nickname = userAutocompletable.getNickname();
        if (nickname == null) {
            nickname = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, userAutocompletable.getUser(), null, null, 3, null).toString();
        }
        UserAutocompletable userAutocompletable2 = (UserAutocompletable) o2;
        String nickname2 = userAutocompletable2.getNickname();
        if (nickname2 == null) {
            nickname2 = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, userAutocompletable2.getUser(), null, null, 3, null).toString();
        }
        return AutocompletableKt.lower(nickname).compareTo(AutocompletableKt.lower(nickname2));
    }
}
