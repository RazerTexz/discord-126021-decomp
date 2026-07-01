package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.ChannelUtils;
import com.discord.models.commands.Application;
import com.discord.utilities.user.UserUtils;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Comparator;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompletableComparator implements Comparator<Autocompletable> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Autocompletable autocompletable, Autocompletable autocompletable2) {
        return compare2(autocompletable, autocompletable2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Autocompletable o1, Autocompletable o2) {
        m.checkNotNullParameter(o1, "o1");
        m.checkNotNullParameter(o2, "o2");
        if (!m.areEqual(a0.getOrCreateKotlinClass(o1.getClass()), a0.getOrCreateKotlinClass(o2.getClass()))) {
            return m.compare(AutocompletableKt.getSortIndex(o1), AutocompletableKt.getSortIndex(o2));
        }
        if (o1 instanceof ApplicationCommandChoiceAutocompletable) {
            return AutocompletableKt.access$lower(((ApplicationCommandChoiceAutocompletable) o1).getChoice().getName()).compareTo(AutocompletableKt.access$lower(((ApplicationCommandChoiceAutocompletable) o2).getChoice().getName()));
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
            if (m.areEqual(lValueOf, application2 != null ? Long.valueOf(application2.getId()) : null)) {
                return AutocompletableKt.access$lower(applicationCommandAutocompletable2.getCommand().getName()).compareTo(AutocompletableKt.access$lower(applicationCommandAutocompletable.getCommand().getName()));
            }
            Application application3 = applicationCommandAutocompletable2.getApplication();
            String strAccess$lower = AutocompletableKt.access$lower(String.valueOf(application3 != null ? application3.getName() : null));
            Application application4 = applicationCommandAutocompletable.getApplication();
            return strAccess$lower.compareTo(AutocompletableKt.access$lower(String.valueOf(application4 != null ? application4.getName() : null)));
        }
        if (o1 instanceof ApplicationPlaceholder) {
            return AutocompletableKt.access$lower(((ApplicationPlaceholder) o1).getApplication().getName()).compareTo(AutocompletableKt.access$lower(((ApplicationPlaceholder) o2).getApplication().getName()));
        }
        if (o1 instanceof ChannelAutocompletable) {
            ChannelAutocompletable channelAutocompletable = (ChannelAutocompletable) o2;
            ChannelAutocompletable channelAutocompletable2 = (ChannelAutocompletable) o1;
            String strAccess$lower2 = AutocompletableKt.access$lower(ChannelUtils.c(channelAutocompletable2.getChannel()));
            String strAccess$lower3 = AutocompletableKt.access$lower(ChannelUtils.c(channelAutocompletable.getChannel()));
            return m.areEqual(strAccess$lower2, strAccess$lower3) ^ true ? strAccess$lower2.compareTo(strAccess$lower3) : (channelAutocompletable2.getChannel().getId() > channelAutocompletable.getChannel().getId() ? 1 : (channelAutocompletable2.getChannel().getId() == channelAutocompletable.getChannel().getId() ? 0 : -1));
        }
        if (o1 instanceof EmojiAutocompletable) {
            String firstName = ((EmojiAutocompletable) o1).getEmoji().getFirstName();
            m.checkNotNullExpressionValue(firstName, "o1.emoji.firstName");
            String strAccess$lower4 = AutocompletableKt.access$lower(firstName);
            String firstName2 = ((EmojiAutocompletable) o2).getEmoji().getFirstName();
            m.checkNotNullExpressionValue(firstName2, "o2c.emoji.firstName");
            return strAccess$lower4.compareTo(AutocompletableKt.access$lower(firstName2));
        }
        if (o1 instanceof EmojiUpsellPlaceholder) {
            return 0;
        }
        if (o1 instanceof GlobalRoleAutocompletable) {
            return AutocompletableKt.access$lower(((GlobalRoleAutocompletable) o1).getText()).compareTo(AutocompletableKt.access$lower(((GlobalRoleAutocompletable) o2).getText()));
        }
        if (o1 instanceof RoleAutocompletable) {
            return AutocompletableKt.access$lower(((RoleAutocompletable) o1).getRole().getName()).compareTo(AutocompletableKt.access$lower(((RoleAutocompletable) o2).getRole().getName()));
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
        return AutocompletableKt.access$lower(nickname).compareTo(AutocompletableKt.access$lower(nickname2));
    }
}
