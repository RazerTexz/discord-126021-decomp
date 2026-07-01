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
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.time.Clock;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: LocalMessageCreators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalMessageCreatorsKt {
    public static final Message createInvalidAttachmentsMessage(long j, User user, Clock clock, List<LocalAttachment> list) {
        m.checkNotNullParameter(user, "author");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(list, "localAttachments");
        long jComputeNonce = NonceGenerator.Companion.computeNonce(clock);
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Boolean bool = Boolean.FALSE;
        return new Message(jComputeNonce, j, null, user, "", utcDateTime, null, bool, bool, n.emptyList(), n.emptyList(), n.emptyList(), n.emptyList(), n.emptyList(), String.valueOf(jComputeNonce), bool, null, -3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, null, null, null, null, list, null, -2147483644, 94, null);
    }

    public static final Message createLocalApplicationCommandMessage(long j, String str, long j2, User user, User user2, boolean z2, boolean z3, Long l, Clock clock) {
        m.checkNotNullParameter(user2, "application");
        m.checkNotNullParameter(clock, "clock");
        int i = z2 ? -4 : -5;
        Long l2 = z3 ? 128L : null;
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Interaction interaction = new Interaction(l, 2, str, user, null);
        return new Message(j, j2, null, user2, "", utcDateTime, null, null, null, null, null, null, null, null, String.valueOf(j), null, null, Integer.valueOf(i), null, null, Long.valueOf(user2.getId()), null, l2, null, null, null, interaction, null, null, null, null, null, false, null, null, null, null, null, null, -72499260, Opcodes.LAND, null);
    }

    public static final Message createLocalMessage(String str, long j, User user, List<User> list, boolean z2, boolean z3, Application application, MessageActivity messageActivity, Clock clock, List<LocalAttachment> list2, Long l, Long l2, Integer num, List<? extends BaseSticker> list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        ArrayList arrayList;
        m.checkNotNullParameter(str, "content");
        m.checkNotNullParameter(user, "author");
        m.checkNotNullParameter(clock, "clock");
        long jComputeNonce = NonceGenerator.Companion.computeNonce(clock);
        int i = z2 ? -2 : -1;
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Boolean bool = Boolean.FALSE;
        List listEmptyList = n.emptyList();
        List listEmptyList2 = n.emptyList();
        List listEmptyList3 = n.emptyList();
        List listEmptyList4 = n.emptyList();
        String strValueOf = String.valueOf(jComputeNonce);
        Integer numValueOf = Integer.valueOf(i);
        if (list3 != null) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((BaseSticker) it.next()).c());
            }
        } else {
            arrayList = null;
        }
        return new Message(jComputeNonce, j, null, user, str, utcDateTime, null, bool, bool, list, listEmptyList, listEmptyList2, listEmptyList3, listEmptyList4, strValueOf, bool, null, numValueOf, messageActivity, application, null, messageReference, null, null, arrayList, null, null, null, null, null, Boolean.FALSE, null, z3, messageAllowedMentions, num, l, l2, list2, captchaHelper$CaptchaPayload, -2147483644, 0, null);
    }

    public static /* synthetic */ Message createLocalMessage$default(String str, long j, User user, List list, boolean z2, boolean z3, Application application, MessageActivity messageActivity, Clock clock, List list2, Long l, Long l2, Integer num, List list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        return createLocalMessage(str, j, user, list, z2, z3, application, messageActivity, clock, list2, l, l2, num, list3, messageReference, messageAllowedMentions, (i & 65536) != 0 ? null : captchaHelper$CaptchaPayload);
    }

    public static final Message createThreadStarterMessageNotFoundMessage(long j, User user, Clock clock) {
        m.checkNotNullParameter(user, "author");
        m.checkNotNullParameter(clock, "clock");
        long jComputeNonce = NonceGenerator.Companion.computeNonce(clock);
        return new Message(jComputeNonce, j, null, user, "", new UtcDateTime(clock.currentTimeMillis()), null, null, null, null, null, null, null, null, String.valueOf(jComputeNonce), null, null, -7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -147516, Opcodes.LAND, null);
    }

    public static final Message createWithReactions(Message message, LinkedHashMap<String, MessageReaction> linkedHashMap) {
        List listEmptyList;
        Collection<MessageReaction> collectionValues;
        m.checkNotNullParameter(message, "other");
        if (linkedHashMap == null || (collectionValues = linkedHashMap.values()) == null || (listEmptyList = u.toList(collectionValues)) == null) {
            listEmptyList = n.emptyList();
        }
        return Message.copy$default(message, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, listEmptyList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null);
    }

    public static final Message createLocalApplicationCommandMessage(Message message, Long l, boolean z2, boolean z3, Clock clock) {
        m.checkNotNullParameter(message, "other");
        m.checkNotNullParameter(clock, "clock");
        Interaction interaction = message.getInteraction();
        String strB = interaction != null ? interaction.getName() : null;
        Interaction interaction2 = message.getInteraction();
        User userC = interaction2 != null ? interaction2.getUser() : null;
        long id2 = message.getId();
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        m.checkNotNull(author);
        return createLocalApplicationCommandMessage(id2, strB, channelId, userC, author, z2, z3, l, clock);
    }
}
