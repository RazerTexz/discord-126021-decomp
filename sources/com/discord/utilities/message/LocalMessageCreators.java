package com.discord.utilities.message;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.application.Application;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.LocalAttachment;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.message.Message;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.time.Clock;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: com.discord.utilities.message.LocalMessageCreatorsKt, reason: use source file name */
/* JADX INFO: compiled from: LocalMessageCreators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalMessageCreators {
    public static final Message createInvalidAttachmentsMessage(long j, User user, Clock clock, List<LocalAttachment> list) {
        Intrinsics3.checkNotNullParameter(user, "author");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(list, "localAttachments");
        long jComputeNonce = NonceGenerator.INSTANCE.computeNonce(clock);
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Boolean bool = Boolean.FALSE;
        return new Message(jComputeNonce, j, null, user, "", utcDateTime, null, bool, bool, Collections2.emptyList(), Collections2.emptyList(), Collections2.emptyList(), Collections2.emptyList(), Collections2.emptyList(), String.valueOf(jComputeNonce), bool, null, -3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, null, null, null, null, list, null, -2147483644, 94, null);
    }

    public static final Message createLocalApplicationCommandMessage(long j, String str, long j2, User user, User user2, boolean z2, boolean z3, Long l, Clock clock) {
        Intrinsics3.checkNotNullParameter(user2, "application");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        int i = z2 ? -4 : -5;
        Long l2 = z3 ? 128L : null;
        Interaction interaction = new Interaction(l, 2, str, user, null);
        return new Message(j, j2, null, user2, "", new UtcDateTime(clock.currentTimeMillis()), null, null, null, null, null, null, null, null, String.valueOf(j), null, null, Integer.valueOf(i), null, null, Long.valueOf(user2.getId()), null, l2, null, null, null, interaction, null, null, null, null, null, false, null, null, null, null, null, null, -72499260, Opcodes.LAND, null);
    }

    public static final Message createLocalMessage(String str, long j, User user, List<User> list, boolean z2, boolean z3, Application application, MessageActivity messageActivity, Clock clock, List<LocalAttachment> list2, Long l, Long l2, Integer num, List<? extends BaseSticker> list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, CaptchaHelper.CaptchaPayload captchaPayload) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(str, "content");
        Intrinsics3.checkNotNullParameter(user, "author");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        long jComputeNonce = NonceGenerator.INSTANCE.computeNonce(clock);
        int i = z2 ? -2 : -1;
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Long l3 = null;
        UtcDateTime utcDateTime2 = null;
        Boolean bool = Boolean.FALSE;
        List listEmptyList = Collections2.emptyList();
        List listEmptyList2 = Collections2.emptyList();
        List listEmptyList3 = Collections2.emptyList();
        List listEmptyList4 = Collections2.emptyList();
        String strValueOf = String.valueOf(jComputeNonce);
        Long l4 = null;
        Integer numValueOf = Integer.valueOf(i);
        Long l5 = null;
        Long l6 = null;
        List list4 = null;
        if (list3 != null) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((BaseSticker) it.next()).c());
            }
        } else {
            arrayList = null;
        }
        return new Message(jComputeNonce, j, l3, user, str, utcDateTime, utcDateTime2, bool, bool, list, listEmptyList, listEmptyList2, listEmptyList3, listEmptyList4, strValueOf, bool, l4, numValueOf, messageActivity, application, l5, messageReference, l6, list4, arrayList, null, null, null, null, null, Boolean.FALSE, null, z3, messageAllowedMentions, num, l, l2, list2, captchaPayload, -2147483644, 0, null);
    }

    public static final Message createThreadStarterMessageNotFoundMessage(long j, User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "author");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        long jComputeNonce = NonceGenerator.INSTANCE.computeNonce(clock);
        return new Message(jComputeNonce, j, null, user, "", new UtcDateTime(clock.currentTimeMillis()), null, null, null, null, null, null, null, null, String.valueOf(jComputeNonce), null, null, -7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -147516, Opcodes.LAND, null);
    }

    public static final Message createWithReactions(Message message, LinkedHashMap<String, MessageReaction> linkedHashMap) {
        List listEmptyList;
        Collection<MessageReaction> collectionValues;
        Intrinsics3.checkNotNullParameter(message, "other");
        if (linkedHashMap == null || (collectionValues = linkedHashMap.values()) == null || (listEmptyList = _Collections.toList(collectionValues)) == null) {
            listEmptyList = Collections2.emptyList();
        }
        return Message.copy$default(message, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, listEmptyList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null);
    }

    public static final Message createLocalApplicationCommandMessage(Message message, Long l, boolean z2, boolean z3, Clock clock) {
        Intrinsics3.checkNotNullParameter(message, "other");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Interaction interaction = message.getInteraction();
        String name = interaction != null ? interaction.getName() : null;
        Interaction interaction2 = message.getInteraction();
        User user = interaction2 != null ? interaction2.getUser() : null;
        long id2 = message.getId();
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        Intrinsics3.checkNotNull(author);
        return createLocalApplicationCommandMessage(id2, name, channelId, user, author, z2, z3, l, clock);
    }
}
