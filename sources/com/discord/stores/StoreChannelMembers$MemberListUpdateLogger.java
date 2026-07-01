package com.discord.stores;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Delete;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Insert;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Invalidate;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Sync;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Update;
import com.discord.utilities.logging.Logger;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$MemberListUpdateLogger {
    private static final String ERROR_TAG = "MemberListUpdateError";
    private static final int MAX_UPDATE_COUNT = 20;
    public static final StoreChannelMembers$MemberListUpdateLogger INSTANCE = new StoreChannelMembers$MemberListUpdateLogger();
    private static final Map<String, List<String>> opLogs = new HashMap();

    private StoreChannelMembers$MemberListUpdateLogger() {
    }

    private final String makeLogKey(long guildId, String memberListId) {
        return guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + memberListId;
    }

    public final void dumpLogs(long guildId, String memberListId, Exception exception) {
        m.checkNotNullParameter(memberListId, "memberListId");
        m.checkNotNullParameter(exception, "exception");
        List<String> list = opLogs.get(makeLogKey(guildId, memberListId));
        StringBuilder sb = new StringBuilder();
        sb.append("guildId: ");
        sb.append(guildId);
        sb.append(" -- memberListId: ");
        sb.append(memberListId);
        sb.append(" -- LAST 20 UPDATES:\n");
        sb.append(list != null ? u.joinToString$default(list, "\n", null, null, 0, null, null, 62, null) : null);
        FirebaseCrashlytics.getInstance().log(sb.toString());
        Logger.e$default(AppLog.g, ERROR_TAG, new StoreChannelMembers$MemberListUpdateException(exception), null, 4, null);
    }

    public final void logUpdate(ModelGuildMemberListUpdate update) {
        String string;
        m.checkNotNullParameter(update, "update");
        List<ModelGuildMemberListUpdate$Operation> operations = update.getOperations();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(operations, 10));
        for (ModelGuildMemberListUpdate$Operation modelGuildMemberListUpdate$Operation : operations) {
            if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Sync) {
                StringBuilder sbU = a.U("  SYNC: ");
                sbU.append(((ModelGuildMemberListUpdate$Operation$Sync) modelGuildMemberListUpdate$Operation).getRange());
                string = sbU.toString();
            } else if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Update) {
                StringBuilder sbU2 = a.U("  UPDATE: ");
                sbU2.append(((ModelGuildMemberListUpdate$Operation$Update) modelGuildMemberListUpdate$Operation).getIndex());
                string = sbU2.toString();
            } else if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Insert) {
                StringBuilder sbU3 = a.U("  INSERT: ");
                sbU3.append(((ModelGuildMemberListUpdate$Operation$Insert) modelGuildMemberListUpdate$Operation).getIndex());
                string = sbU3.toString();
            } else if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Delete) {
                StringBuilder sbU4 = a.U("  DELETE: ");
                sbU4.append(((ModelGuildMemberListUpdate$Operation$Delete) modelGuildMemberListUpdate$Operation).getIndex());
                string = sbU4.toString();
            } else {
                if (!(modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Invalidate)) {
                    throw new NoWhenBranchMatchedException();
                }
                StringBuilder sbU5 = a.U("  INVALIDATE: ");
                sbU5.append(((ModelGuildMemberListUpdate$Operation$Invalidate) modelGuildMemberListUpdate$Operation).getRange());
                string = sbU5.toString();
            }
            arrayList.add(string);
        }
        String strJ = a.J(a.U("GROUPS: ["), u.joinToString$default(update.getGroups(), ",", null, null, 0, null, StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1.INSTANCE, 30, null), "]");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        arrayList2.add(strJ);
        arrayList2.add("-----");
        String strMakeLogKey = makeLogKey(update.getGuildId(), update.getId());
        Map<String, List<String>> map = opLogs;
        List<String> arrayList3 = map.get(strMakeLogKey);
        if (arrayList3 == null) {
            arrayList3 = new ArrayList<>();
        }
        arrayList3.add(u.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null));
        if (arrayList3.size() > 20) {
            arrayList3.remove(0);
        }
        map.put(strMakeLogKey, arrayList3);
    }
}
