package com.discord.utilities.auditlogs;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateUtils;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$plurals;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelAuditLogEntry$ActionType;
import com.discord.models.domain.ModelAuditLogEntry$Change;
import com.discord.models.domain.ModelAuditLogEntry$Options;
import com.discord.models.domain.ModelAuditLogEntry$TargetType;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.g;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;

/* JADX INFO: compiled from: AuditLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogUtils {
    public static final AuditLogUtils INSTANCE = new AuditLogUtils();

    /* JADX INFO: renamed from: ALL_ACTION_TYPES$delegate, reason: from kotlin metadata */
    private static final Lazy ALL_ACTION_TYPES = g.lazy(AuditLogUtils$ALL_ACTION_TYPES$2.INSTANCE);

    private AuditLogUtils() {
    }

    @StringRes
    private final int getEntryTitle(ModelAuditLogEntry auditLogEntry) {
        int actionTypeId = auditLogEntry.getActionTypeId();
        ModelAuditLogEntry$Change modelAuditLogEntry$Change = null;
        Object obj = null;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change2 = null;
        Object obj2 = null;
        switch (actionTypeId) {
            case 1:
                return 2131890908;
            case 20:
                return 2131890947;
            case 21:
                return 2131890954;
            case 22:
                return 2131890942;
            case 23:
                return 2131890943;
            case 24:
                return 2131890959;
            case 25:
                return 2131890956;
            case 26:
                return 2131890948;
            case 27:
                return 2131890946;
            case 28:
                return 2131890813;
            case 110:
                List<ModelAuditLogEntry$Change> changes = auditLogEntry.getChanges();
                if (changes != null) {
                    for (Object obj3 : changes) {
                        ModelAuditLogEntry$Change modelAuditLogEntry$Change3 = (ModelAuditLogEntry$Change) obj3;
                        m.checkNotNullExpressionValue(modelAuditLogEntry$Change3, "it");
                        if (m.areEqual(modelAuditLogEntry$Change3.getKey(), "type")) {
                            obj2 = obj3;
                            modelAuditLogEntry$Change = (ModelAuditLogEntry$Change) obj2;
                        }
                    }
                    modelAuditLogEntry$Change = (ModelAuditLogEntry$Change) obj2;
                }
                if (modelAuditLogEntry$Change == null) {
                    return 0;
                }
                Object newValue = modelAuditLogEntry$Change.getNewValue();
                Objects.requireNonNull(newValue, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue = (int) ((Long) newValue).longValue();
                if (iLongValue != 10) {
                    return iLongValue != 12 ? 2131891016 : 2131890966;
                }
                return 2131890794;
            case 111:
                return 2131891026;
            case 112:
                return 2131891017;
            default:
                switch (actionTypeId) {
                    case 10:
                        List<ModelAuditLogEntry$Change> changes2 = auditLogEntry.getChanges();
                        if (changes2 != null) {
                            for (Object obj4 : changes2) {
                                ModelAuditLogEntry$Change modelAuditLogEntry$Change4 = (ModelAuditLogEntry$Change) obj4;
                                m.checkNotNullExpressionValue(modelAuditLogEntry$Change4, "it");
                                if (m.areEqual(modelAuditLogEntry$Change4.getKey(), "type")) {
                                    obj = obj4;
                                    modelAuditLogEntry$Change2 = (ModelAuditLogEntry$Change) obj;
                                }
                            }
                            modelAuditLogEntry$Change2 = (ModelAuditLogEntry$Change) obj;
                        }
                        if (modelAuditLogEntry$Change2 == null) {
                            return 0;
                        }
                        Object newValue2 = modelAuditLogEntry$Change2.getNewValue();
                        Objects.requireNonNull(newValue2, "null cannot be cast to non-null type kotlin.Long");
                        int iLongValue2 = (int) ((Long) newValue2).longValue();
                        if (iLongValue2 == 2) {
                            return 2131890853;
                        }
                        if (iLongValue2 != 4) {
                            return iLongValue2 != 13 ? 2131890842 : 2131890841;
                        }
                        return 2131890819;
                    case 11:
                        return 2131890848;
                    case 12:
                        return 2131890822;
                    case 13:
                        return 2131890828;
                    case 14:
                        return 2131890830;
                    case 15:
                        return 2131890829;
                    default:
                        switch (actionTypeId) {
                            case 30:
                                return 2131890970;
                            case 31:
                                return 2131890982;
                            case 32:
                                return 2131890971;
                            default:
                                switch (actionTypeId) {
                                    case 40:
                                        return 2131890932;
                                    case 41:
                                        return 2131890940;
                                    case 42:
                                        return 2131890933;
                                    default:
                                        switch (actionTypeId) {
                                            case 50:
                                                return 2131891043;
                                            case 51:
                                                return 2131891047;
                                            case 52:
                                                return 2131891044;
                                            default:
                                                switch (actionTypeId) {
                                                    case 60:
                                                        return 2131890863;
                                                    case 61:
                                                        return 2131890867;
                                                    case 62:
                                                        return 2131890864;
                                                    default:
                                                        switch (actionTypeId) {
                                                            case 72:
                                                                return 2131890961;
                                                            case 73:
                                                                return 2131890960;
                                                            case 74:
                                                                return 2131890962;
                                                            case 75:
                                                                return 2131890963;
                                                            default:
                                                                switch (actionTypeId) {
                                                                    case 80:
                                                                        return 2131890922;
                                                                    case 81:
                                                                        return 2131890929;
                                                                    case 82:
                                                                        return 2131890923;
                                                                    case 83:
                                                                        return 2131891002;
                                                                    case 84:
                                                                        return 2131891007;
                                                                    case 85:
                                                                        return auditLogEntry.getUserId() == 0 ? 2131891004 : 2131891003;
                                                                    default:
                                                                        switch (actionTypeId) {
                                                                            case 90:
                                                                                return 2131891008;
                                                                            case 91:
                                                                                return 2131891010;
                                                                            case 92:
                                                                                return 2131891009;
                                                                            default:
                                                                                switch (actionTypeId) {
                                                                                    case 100:
                                                                                        return 2131890985;
                                                                                    case 101:
                                                                                        return 2131891001;
                                                                                    case 102:
                                                                                        return 2131890986;
                                                                                    default:
                                                                                        AppLog appLog = AppLog.g;
                                                                                        StringBuilder sbU = a.U("Unknown audit log action type: ");
                                                                                        sbU.append(auditLogEntry.getActionTypeId());
                                                                                        Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
                                                                                        return 2131891028;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static /* synthetic */ CharSequence getHeaderString$default(AuditLogUtils auditLogUtils, ModelAuditLogEntry modelAuditLogEntry, CharSequence charSequence, Context context, Map map, String str, int i, Object obj) {
        if ((i & 16) != 0) {
            str = "";
        }
        return auditLogUtils.getHeaderString(modelAuditLogEntry, charSequence, context, map, str);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    private final String getTargetText(ModelAuditLogEntry auditLogEntry, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, CharSequence>> targets, String channelPrefix) {
        CharSequence string;
        ModelAuditLogEntry$TargetType targetType = auditLogEntry.getTargetType();
        if (targetType == ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE) {
            targetType = ModelAuditLogEntry$TargetType.CHANNEL;
        }
        Map<Long, CharSequence> map = targets.get(targetType);
        if (map == null || (string = map.get(Long.valueOf(auditLogEntry.getTargetId()))) == null) {
            if (targetType != null) {
                int iOrdinal = targetType.ordinal();
                if (iOrdinal == 3) {
                    StringBuilder sbU = a.U(channelPrefix);
                    sbU.append(getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_NAME));
                    string = sbU.toString();
                } else if (iOrdinal == 10) {
                    string = getTargetValue(auditLogEntry, "type");
                } else if (iOrdinal == 6) {
                    ModelAuditLogEntry$Options options = auditLogEntry.getOptions();
                    if (options == null || (string = options.getRoleName()) == null) {
                        string = getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    }
                } else if (iOrdinal == 7) {
                    string = getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_CODE);
                } else if (iOrdinal != 8) {
                    string = null;
                } else {
                    string = getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_NAME);
                }
            } else {
                string = null;
            }
        }
        if (string == null) {
            string = Long.valueOf(auditLogEntry.getTargetId());
        }
        return string.toString();
    }

    public static /* synthetic */ String getTargetText$default(AuditLogUtils auditLogUtils, ModelAuditLogEntry modelAuditLogEntry, Map map, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        return auditLogUtils.getTargetText(modelAuditLogEntry, map, str);
    }

    private final Object getTargetValue(ModelAuditLogEntry modelAuditLogEntry, String str) {
        Object next;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change;
        List<ModelAuditLogEntry$Change> changes = modelAuditLogEntry.getChanges();
        if (changes == null) {
            return null;
        }
        Iterator<T> it = changes.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            modelAuditLogEntry$Change = (ModelAuditLogEntry$Change) next;
            m.checkNotNullExpressionValue(modelAuditLogEntry$Change, "it");
        } while (!m.areEqual(modelAuditLogEntry$Change.getKey(), str));
        ModelAuditLogEntry$Change modelAuditLogEntry$Change2 = (ModelAuditLogEntry$Change) next;
        if (modelAuditLogEntry$Change2 != null) {
            return modelAuditLogEntry$Change2.getValue();
        }
        return null;
    }

    private final CharSequence getTimestampText(long timestamp, Context context) {
        Clock clock = ClockFactory.get();
        long jCurrentTimeMillis = clock.currentTimeMillis() - timestamp;
        CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(timestamp, clock.currentTimeMillis(), 86400000L, 131092);
        if (TimeUnit.MILLISECONDS.toDays(jCurrentTimeMillis) < 7) {
            return b.h(context, 2131891027, new Object[]{relativeTimeSpanString, DateUtils.formatDateTime(context, timestamp, 1)}, null, 4);
        }
        m.checkNotNullExpressionValue(relativeTimeSpanString, "timeString");
        return relativeTimeSpanString;
    }

    public final List<Integer> getALL_ACTION_TYPES() {
        return (List) ALL_ACTION_TYPES.getValue();
    }

    @StringRes
    public final int getActionName(int actionTypeId) {
        if (actionTypeId == 0) {
            return 2131891181;
        }
        if (actionTypeId == 1) {
            return 2131890753;
        }
        switch (actionTypeId) {
            case 10:
                return 2131890739;
            case 11:
                return 2131890744;
            case 12:
                return 2131890740;
            case 13:
                return 2131890741;
            case 14:
                return 2131890743;
            case 15:
                return 2131890742;
            default:
                switch (actionTypeId) {
                    case 20:
                        return 2131890763;
                    case 21:
                        return 2131890765;
                    case 22:
                        return 2131890760;
                    case 23:
                        return 2131890761;
                    case 24:
                        return 2131890767;
                    case 25:
                        return 2131890766;
                    case 26:
                        return 2131890764;
                    case 27:
                        return 2131890762;
                    case 28:
                        return 2131890738;
                    case 100:
                        return 2131890750;
                    case 101:
                        return 2131890752;
                    case 102:
                        return 2131890751;
                    case 110:
                        return 2131890781;
                    case 111:
                        return 2131890783;
                    case 112:
                        return 2131890782;
                    default:
                        switch (actionTypeId) {
                            case 30:
                                return 2131890772;
                            case 31:
                                return 2131890774;
                            case 32:
                                return 2131890773;
                            default:
                                switch (actionTypeId) {
                                    case 40:
                                        return 2131890757;
                                    case 41:
                                        return 2131890759;
                                    case 42:
                                        return 2131890758;
                                    default:
                                        switch (actionTypeId) {
                                            case 50:
                                                return 2131890784;
                                            case 51:
                                                return 2131890786;
                                            case 52:
                                                return 2131890785;
                                            default:
                                                switch (actionTypeId) {
                                                    case 60:
                                                        return 2131890745;
                                                    case 61:
                                                        return 2131890747;
                                                    case 62:
                                                        return 2131890746;
                                                    default:
                                                        switch (actionTypeId) {
                                                            case 72:
                                                                return 2131890769;
                                                            case 73:
                                                                return 2131890768;
                                                            case 74:
                                                                return 2131890770;
                                                            case 75:
                                                                return 2131890771;
                                                            default:
                                                                switch (actionTypeId) {
                                                                    case 80:
                                                                        return 2131890754;
                                                                    case 81:
                                                                        return 2131890756;
                                                                    case 82:
                                                                        return 2131890755;
                                                                    case 83:
                                                                        return 2131890775;
                                                                    case 84:
                                                                        return 2131890777;
                                                                    case 85:
                                                                        return 2131890776;
                                                                    default:
                                                                        switch (actionTypeId) {
                                                                            case 90:
                                                                                return 2131890778;
                                                                            case 91:
                                                                                return 2131890780;
                                                                            case 92:
                                                                                return 2131890779;
                                                                            default:
                                                                                return 0;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @DrawableRes
    public final int getActionTypeImage(int actionTypeId) {
        ModelAuditLogEntry$ActionType actionType = ModelAuditLogEntry.getActionType(actionTypeId);
        if (actionType != null) {
            int iOrdinal = actionType.ordinal();
            if (iOrdinal == 1) {
                return 2131231539;
            }
            if (iOrdinal == 2) {
                return 2131231541;
            }
            if (iOrdinal == 3) {
                return 2131231540;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0243  */
    /* JADX WARN: Code duplicated, block: B:149:0x032c  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b5  */
    public final CharSequence getHeaderString(ModelAuditLogEntry auditLogEntry, CharSequence username, Context context, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, CharSequence>> targets, String prefix) {
        Object oldValue;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change;
        CharSequence charSequenceValueOf;
        Object value;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change2;
        CharSequence charSequenceValueOf2;
        CharSequence charSequenceValueOf3;
        CharSequence charSequenceValueOf4;
        Object value2;
        String strValueOf;
        Object next;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change3;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change4;
        m.checkNotNullParameter(auditLogEntry, "auditLogEntry");
        m.checkNotNullParameter(username, "username");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(targets, "targets");
        m.checkNotNullParameter(prefix, "prefix");
        int actionTypeId = auditLogEntry.getActionTypeId();
        if (actionTypeId == 21) {
            int entryTitle = getEntryTitle(auditLogEntry);
            Object[] objArr = new Object[2];
            objArr[0] = username;
            Resources resources = context.getResources();
            m.checkNotNullExpressionValue(resources, "context.resources");
            ModelAuditLogEntry$Options options = auditLogEntry.getOptions();
            int membersRemoved = options != null ? options.getMembersRemoved() : 0;
            Object[] objArr2 = new Object[1];
            ModelAuditLogEntry$Options options2 = auditLogEntry.getOptions();
            objArr2[0] = Integer.valueOf(options2 != null ? options2.getMembersRemoved() : 0);
            objArr[1] = StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.guild_settings_audit_log_member_prune_count, membersRemoved, objArr2);
            return b.h(context, entryTitle, objArr, null, 4);
        }
        if (actionTypeId == 42) {
            int entryTitle2 = getEntryTitle(auditLogEntry);
            Object[] objArr3 = new Object[2];
            objArr3[0] = username;
            List<ModelAuditLogEntry$Change> changes = auditLogEntry.getChanges();
            if (changes != null) {
                Iterator<T> it = changes.iterator();
                do {
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    modelAuditLogEntry$Change = (ModelAuditLogEntry$Change) it.next();
                    m.checkNotNullExpressionValue(modelAuditLogEntry$Change, "it");
                } while (!m.areEqual(modelAuditLogEntry$Change.getKey(), ModelAuditLogEntry.CHANGE_KEY_CODE));
                if (modelAuditLogEntry$Change != null) {
                    oldValue = modelAuditLogEntry$Change.getOldValue();
                } else {
                    oldValue = null;
                }
            } else {
                oldValue = null;
            }
            objArr3[1] = String.valueOf(oldValue);
            return b.h(context, entryTitle2, objArr3, null, 4);
        }
        if (actionTypeId == 26) {
            ModelAuditLogEntry$Options options3 = auditLogEntry.getOptions();
            Long lValueOf = options3 != null ? Long.valueOf(options3.getChannelId()) : null;
            int entryTitle3 = getEntryTitle(auditLogEntry);
            Object[] objArr4 = new Object[3];
            objArr4[0] = username;
            ModelAuditLogEntry$Options options4 = auditLogEntry.getOptions();
            int count = options4 != null ? options4.getCount() : 0;
            Object[] objArr5 = new Object[1];
            ModelAuditLogEntry$Options options5 = auditLogEntry.getOptions();
            objArr5[0] = Integer.valueOf(options5 != null ? options5.getCount() : 0);
            objArr4[1] = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_settings_audit_log_member_move_count, count, objArr5);
            Map<Long, CharSequence> map = targets.get(ModelAuditLogEntry$TargetType.CHANNEL);
            if (map == null || (charSequenceValueOf = map.get(lValueOf)) == null) {
                charSequenceValueOf = lValueOf != null ? String.valueOf(lValueOf.longValue()) : null;
            }
            objArr4[2] = charSequenceValueOf;
            return b.h(context, entryTitle3, objArr4, null, 4);
        }
        if (actionTypeId == 27) {
            int entryTitle4 = getEntryTitle(auditLogEntry);
            Object[] objArr6 = new Object[2];
            objArr6[0] = username;
            ModelAuditLogEntry$Options options6 = auditLogEntry.getOptions();
            int count2 = options6 != null ? options6.getCount() : 0;
            Object[] objArr7 = new Object[1];
            ModelAuditLogEntry$Options options7 = auditLogEntry.getOptions();
            objArr7[0] = Integer.valueOf(options7 != null ? options7.getCount() : 0);
            objArr6[1] = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_settings_audit_log_member_disconnect_count, count2, objArr7);
            return b.h(context, entryTitle4, objArr6, null, 4);
        }
        switch (actionTypeId) {
            case 60:
            case 61:
            case 62:
                int entryTitle5 = getEntryTitle(auditLogEntry);
                Object[] objArr8 = new Object[2];
                objArr8[0] = username;
                List<ModelAuditLogEntry$Change> changes2 = auditLogEntry.getChanges();
                if (changes2 != null) {
                    Iterator<T> it2 = changes2.iterator();
                    do {
                        if (!it2.hasNext()) {
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        modelAuditLogEntry$Change2 = (ModelAuditLogEntry$Change) it2.next();
                        m.checkNotNullExpressionValue(modelAuditLogEntry$Change2, "it");
                    } while (!m.areEqual(modelAuditLogEntry$Change2.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME));
                    if (modelAuditLogEntry$Change2 != null) {
                        value = modelAuditLogEntry$Change2.getValue();
                    } else {
                        value = null;
                    }
                } else {
                    value = null;
                }
                objArr8[1] = String.valueOf(value);
                return b.h(context, entryTitle5, objArr8, null, 4);
            default:
                switch (actionTypeId) {
                    case 72:
                        ModelAuditLogEntry$Options options8 = auditLogEntry.getOptions();
                        Long lValueOf2 = options8 != null ? Long.valueOf(options8.getChannelId()) : null;
                        int entryTitle6 = getEntryTitle(auditLogEntry);
                        Object[] objArr9 = new Object[4];
                        objArr9[0] = username;
                        ModelAuditLogEntry$Options options9 = auditLogEntry.getOptions();
                        int count3 = options9 != null ? options9.getCount() : 0;
                        Object[] objArr10 = new Object[1];
                        ModelAuditLogEntry$Options options10 = auditLogEntry.getOptions();
                        objArr10[0] = Integer.valueOf(options10 != null ? options10.getCount() : 0);
                        objArr9[1] = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_settings_audit_log_message_delete_count, count3, objArr10);
                        objArr9[2] = getTargetText(auditLogEntry, targets, prefix);
                        Map<Long, CharSequence> map2 = targets.get(ModelAuditLogEntry$TargetType.CHANNEL);
                        if (map2 == null || (charSequenceValueOf2 = map2.get(lValueOf2)) == null) {
                            charSequenceValueOf2 = lValueOf2 != null ? String.valueOf(lValueOf2.longValue()) : null;
                        }
                        objArr9[3] = charSequenceValueOf2;
                        return b.h(context, entryTitle6, objArr9, null, 4);
                    case 73:
                        int entryTitle7 = getEntryTitle(auditLogEntry);
                        Object[] objArr11 = new Object[3];
                        objArr11[0] = username;
                        ModelAuditLogEntry$Options options11 = auditLogEntry.getOptions();
                        int count4 = options11 != null ? options11.getCount() : 0;
                        Object[] objArr12 = new Object[1];
                        ModelAuditLogEntry$Options options12 = auditLogEntry.getOptions();
                        objArr12[0] = Integer.valueOf(options12 != null ? options12.getCount() : 0);
                        objArr11[1] = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_settings_audit_log_message_bulk_delete_count, count4, objArr12);
                        objArr11[2] = getTargetText(auditLogEntry, targets, prefix);
                        return b.h(context, entryTitle7, objArr11, null, 4);
                    case 74:
                    case 75:
                        ModelAuditLogEntry$Options options13 = auditLogEntry.getOptions();
                        Long lValueOf3 = options13 != null ? Long.valueOf(options13.getChannelId()) : null;
                        int entryTitle8 = getEntryTitle(auditLogEntry);
                        Object[] objArr13 = new Object[3];
                        objArr13[0] = username;
                        objArr13[1] = getTargetText(auditLogEntry, targets, prefix);
                        Map<Long, CharSequence> map3 = targets.get(ModelAuditLogEntry$TargetType.CHANNEL);
                        if (map3 == null || (charSequenceValueOf3 = map3.get(lValueOf3)) == null) {
                            charSequenceValueOf3 = lValueOf3 != null ? String.valueOf(lValueOf3.longValue()) : null;
                        }
                        objArr13[2] = charSequenceValueOf3;
                        return b.h(context, entryTitle8, objArr13, null, 4);
                    default:
                        switch (actionTypeId) {
                            case 83:
                            case 84:
                            case 85:
                                ModelAuditLogEntry$Options options14 = auditLogEntry.getOptions();
                                Long lValueOf4 = options14 != null ? Long.valueOf(options14.getChannelId()) : null;
                                Map<Long, CharSequence> map4 = targets.get(ModelAuditLogEntry$TargetType.CHANNEL);
                                if (map4 == null || (charSequenceValueOf4 = map4.get(lValueOf4)) == null) {
                                    charSequenceValueOf4 = lValueOf4 != null ? String.valueOf(lValueOf4.longValue()) : null;
                                }
                                return auditLogEntry.getUserId() == 0 ? b.h(context, getEntryTitle(auditLogEntry), new Object[]{charSequenceValueOf4}, null, 4) : b.h(context, getEntryTitle(auditLogEntry), new Object[]{username, charSequenceValueOf4}, null, 4);
                            default:
                                switch (actionTypeId) {
                                    case 90:
                                    case 91:
                                    case 92:
                                        int entryTitle9 = getEntryTitle(auditLogEntry);
                                        Object[] objArr14 = new Object[2];
                                        objArr14[0] = username;
                                        Sticker guildSticker = StoreStream.Companion.getGuildStickers().getGuildSticker(auditLogEntry.getTargetId());
                                        if (guildSticker == null || (strValueOf = guildSticker.getName()) == null) {
                                            List<ModelAuditLogEntry$Change> changes3 = auditLogEntry.getChanges();
                                            if (changes3 != null) {
                                                Iterator<T> it3 = changes3.iterator();
                                                do {
                                                    if (it3.hasNext()) {
                                                        next = it3.next();
                                                        modelAuditLogEntry$Change4 = (ModelAuditLogEntry$Change) next;
                                                        m.checkNotNullExpressionValue(modelAuditLogEntry$Change4, "it");
                                                    } else {
                                                        next = null;
                                                    }
                                                    modelAuditLogEntry$Change3 = (ModelAuditLogEntry$Change) next;
                                                    if (modelAuditLogEntry$Change3 != null) {
                                                        value2 = modelAuditLogEntry$Change3.getValue();
                                                    } else {
                                                        value2 = null;
                                                    }
                                                } while (!m.areEqual(modelAuditLogEntry$Change4.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME));
                                                modelAuditLogEntry$Change3 = (ModelAuditLogEntry$Change) next;
                                                if (modelAuditLogEntry$Change3 != null) {
                                                    value2 = modelAuditLogEntry$Change3.getValue();
                                                } else {
                                                    value2 = null;
                                                }
                                            } else {
                                                value2 = null;
                                            }
                                            strValueOf = String.valueOf(value2);
                                        }
                                        objArr14[1] = strValueOf;
                                        return b.h(context, entryTitle9, objArr14, null, 4);
                                    default:
                                        return b.h(context, getEntryTitle(auditLogEntry), new Object[]{username, getTargetText(auditLogEntry, targets, prefix)}, null, 4);
                                }
                        }
                }
        }
    }

    @DrawableRes
    public final int getTargetTypeImage(View view, int actionTypeId) {
        m.checkNotNullParameter(view, "view");
        ModelAuditLogEntry$TargetType targetType = ModelAuditLogEntry.getTargetType(actionTypeId);
        m.checkNotNullExpressionValue(targetType, "ModelAuditLogEntry.getTargetType(actionTypeId)");
        if (actionTypeId == 72) {
            return DrawableCompat.getThemedDrawableRes(view, 2130969467, 0);
        }
        int iOrdinal = targetType.ordinal();
        if (iOrdinal == 0) {
            return DrawableCompat.getThemedDrawableRes(view, 2130969459, 0);
        }
        switch (iOrdinal) {
            case 2:
                return DrawableCompat.getThemedDrawableRes(view, 2130969469, 0);
            case 3:
            case 4:
                return DrawableCompat.getThemedDrawableRes(view, 2130969461, 0);
            case 5:
                return DrawableCompat.getThemedDrawableRes(view, 2130969466, 0);
            case 6:
                return DrawableCompat.getThemedDrawableRes(view, 2130969468, 0);
            case 7:
                return DrawableCompat.getThemedDrawableRes(view, 2130969464, 0);
            case 8:
                return DrawableCompat.getThemedDrawableRes(view, 2130969473, 0);
            case 9:
                return DrawableCompat.getThemedDrawableRes(view, 2130969462, 0);
            case 10:
                return DrawableCompat.getThemedDrawableRes(view, 2130969463, 0);
            case 11:
                return DrawableCompat.getThemedDrawableRes(view, 2130969470, 0);
            case 12:
                return DrawableCompat.getThemedDrawableRes(view, 2130969460, 0);
            case 13:
                return DrawableCompat.getThemedDrawableRes(view, 2130969471, 0);
            case 14:
                return DrawableCompat.getThemedDrawableRes(view, 2130969472, 0);
            default:
                return 0;
        }
    }

    public final long getTimestampStart(ModelAuditLogEntry modelAuditLogEntry) {
        m.checkNotNullParameter(modelAuditLogEntry, "$this$getTimestampStart");
        return (modelAuditLogEntry.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
    }

    public final CharSequence getTimestampString(ModelAuditLogEntry auditLogEntry, Context context) {
        m.checkNotNullParameter(auditLogEntry, "auditLogEntry");
        m.checkNotNullParameter(context, "context");
        if (auditLogEntry.getTimestampEnd() == null) {
            return getTimestampText(getTimestampStart(auditLogEntry), context);
        }
        CharSequence timestampText = getTimestampText(getTimestampStart(auditLogEntry), context);
        Long timestampEnd = auditLogEntry.getTimestampEnd();
        if (timestampEnd == null) {
            timestampEnd = 0L;
        }
        m.checkNotNullExpressionValue(timestampEnd, "auditLogEntry.timestampEnd ?: 0L");
        return timestampText + " - " + getTimestampText(timestampEnd.longValue(), context);
    }
}
