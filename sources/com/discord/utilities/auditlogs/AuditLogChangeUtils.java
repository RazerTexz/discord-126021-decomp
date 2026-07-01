package com.discord.utilities.auditlogs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.StringRes;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$plurals;
import com.discord.R$string;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelAuditLogEntry$ActionType;
import com.discord.models.domain.ModelAuditLogEntry$Change;
import com.discord.models.domain.ModelAuditLogEntry$ChangeNameId;
import com.discord.models.domain.ModelAuditLogEntry$Options;
import com.discord.models.domain.ModelAuditLogEntry$TargetType;
import com.discord.models.user.User;
import com.discord.rtcconnection.MediaSinkWantsManager$VideoQualityMode;
import com.discord.rtcconnection.MediaSinkWantsManager$VideoQualityMode$a;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.time.TimeUtils;
import d0.f0.q;
import d0.g0.t;
import d0.g0.w;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;

/* JADX INFO: compiled from: AuditLogChangeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogChangeUtils {
    public static final AuditLogChangeUtils INSTANCE = new AuditLogChangeUtils();
    private static final List<Integer> RENDERABLE_DELETE_ACTION_TYPES = n.listOf((Object[]) new Integer[]{22, 20, 21});
    private static final List<String> CHANGE_KEYS_REFERENCING_CHANNEL = n.listOf((Object[]) new String[]{ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_AFK_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_SYSTEM_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_RULES_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_UPDATES_CHANNEL_ID});

    private AuditLogChangeUtils() {
    }

    public static final /* synthetic */ int access$getStringForPermission(AuditLogChangeUtils auditLogChangeUtils, long j, ModelAuditLogEntry modelAuditLogEntry) {
        return auditLogChangeUtils.getStringForPermission(j, modelAuditLogEntry);
    }

    private final Pair<HashSet<Long>, HashSet<Long>> calculatePermissionChange(ModelAuditLogEntry$Change change) {
        Object oldValue = change.getOldValue();
        if (!(oldValue instanceof String)) {
            oldValue = null;
        }
        String str = (String) oldValue;
        long j = str != null ? Long.parseLong(str) : 0L;
        Object newValue = change.getNewValue();
        String str2 = (String) (newValue instanceof String ? newValue : null);
        long j2 = str2 != null ? Long.parseLong(str2) : 0L;
        long j3 = (~j) & j2;
        long j4 = j & (~j2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i <= 63; i++) {
            long j5 = 1 << i;
            if ((j3 & j5) == j5) {
                hashSet.add(Long.valueOf(j5));
            }
            if ((j4 & j5) == j5) {
                hashSet2.add(Long.valueOf(j5));
            }
        }
        return new Pair<>(hashSet, hashSet2);
    }

    private final String getChangeNumberString(int number) {
        if (number < 0 || 9 < number) {
            return String.valueOf(number);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        sb.append(number);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    private final CharSequence getChangeTextWithParams(Context context, ModelAuditLogEntry auditLogEntry, ModelAuditLogEntry$Change change, @StringRes int textId, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        CharSequence charSequenceH;
        CharSequence charSequenceH2;
        try {
            if (hasNewValue(change, "type") && auditLogEntry.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL) {
                if (change.getOldValue() == null) {
                    charSequenceH = null;
                } else {
                    Object oldValue = change.getOldValue();
                    if (oldValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    int channelTypeStringResIdFromValue = getChannelTypeStringResIdFromValue(Integer.valueOf((int) ((Long) oldValue).longValue()));
                    if (channelTypeStringResIdFromValue != 0) {
                        charSequenceH = b.h(context, channelTypeStringResIdFromValue, new Object[0], null, 4);
                    } else {
                        charSequenceH = null;
                    }
                }
                if (change.getNewValue() == null) {
                    charSequenceH2 = null;
                } else {
                    Object newValue = change.getNewValue();
                    if (newValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    int channelTypeStringResIdFromValue2 = getChannelTypeStringResIdFromValue(Integer.valueOf((int) ((Long) newValue).longValue()));
                    if (channelTypeStringResIdFromValue2 != 0) {
                        charSequenceH2 = b.h(context, channelTypeStringResIdFromValue2, new Object[0], null, 4);
                    } else {
                        charSequenceH2 = null;
                    }
                }
                return (charSequenceH != null || charSequenceH2 == null) ? b.h(context, textId, new Object[]{charSequenceH, charSequenceH2}, null, 4) : b.h(context, textId, new Object[]{charSequenceH2}, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_COLOR)) {
                Object[] objArr = new Object[1];
                Object[] objArr2 = new Object[1];
                Object newValue2 = change.getNewValue();
                if (newValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr2[0] = Integer.valueOf(16777215 & ((int) ((Long) newValue2).longValue()));
                String str = String.format("#%06X", Arrays.copyOf(objArr2, 1));
                m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
                objArr[0] = str;
                return b.h(context, textId, objArr, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_MAX_AGE)) {
                Object[] objArr3 = new Object[1];
                Object newValue3 = change.getNewValue();
                if (newValue3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr3[0] = DurationUtilsKt.formatInviteExpireAfterString(context, (int) ((Long) newValue3).longValue());
                return b.h(context, textId, objArr3, null, 4);
            }
            if (change.getNewValue() != null && auditLogEntry.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE && (m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED) || m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED) || m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET))) {
                return renderPermissions(change, auditLogEntry, context, targets);
            }
            if (change.getNewValue() != null && (m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED) || m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED))) {
                return b.h(context, textId, new Object[]{getPluralString(context, change).toString() + "\n" + renderPermissionList(change, auditLogEntry, context)}, null, 4);
            }
            if (change.getNewValue() != null && (m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_ROLES_REMOVE) || m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_ROLES_ADD))) {
                return b.h(context, textId, new Object[]{renderRoles(context, change)}, null, 4);
            }
            if (change.getNewValue() != null && CHANGE_KEYS_REFERENCING_CHANNEL.contains(change.getKey())) {
                Object[] objArr4 = new Object[1];
                Map<Long, ? extends CharSequence> map = targets.get(ModelAuditLogEntry$TargetType.CHANNEL);
                objArr4[0] = map != null ? map.get(Long.valueOf(Long.parseLong(change.getValue().toString()))) : null;
                return b.h(context, textId, objArr4, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_BITRATE)) {
                Object[] objArr5 = new Object[1];
                Object newValue4 = change.getNewValue();
                if (newValue4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr5[0] = Long.valueOf(((Long) newValue4).longValue() / ((long) 1000));
                return b.h(context, textId, objArr5, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_OWNER_ID)) {
                Object[] objArr6 = new Object[1];
                User user = StoreStream.Companion.getUsers().getUsers().get(Long.valueOf(Long.parseLong(change.getNewValue().toString())));
                objArr6[0] = user != null ? user.getUsername() : null;
                return b.h(context, textId, objArr6, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_RATE_LIMIT_PER_USER)) {
                Object[] objArr7 = new Object[1];
                Resources resources = context.getResources();
                m.checkNotNullExpressionValue(resources, "context.resources");
                Object newValue5 = change.getNewValue();
                if (newValue5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                int iLongValue = (int) ((Long) newValue5).longValue();
                Object[] objArr8 = new Object[1];
                Object newValue6 = change.getNewValue();
                if (newValue6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr8[0] = Integer.valueOf((int) ((Long) newValue6).longValue());
                objArr7[0] = StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.guild_settings_audit_log_channel_rate_limit_per_user_change_newValue, iLongValue, objArr8);
                return b.h(context, textId, objArr7, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_AFK_TIMEOUT)) {
                Object[] objArr9 = new Object[1];
                Object newValue7 = change.getNewValue();
                if (newValue7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr9[0] = Long.valueOf(((Long) newValue7).longValue() / ((long) 60));
                return b.h(context, textId, objArr9, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_PRUNE_DELETE_DAYS)) {
                Object[] objArr10 = new Object[1];
                Resources resources2 = context.getResources();
                m.checkNotNullExpressionValue(resources2, "context.resources");
                Object newValue8 = change.getNewValue();
                if (newValue8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                int iIntValue = ((Integer) newValue8).intValue();
                Object[] objArr11 = new Object[1];
                Object newValue9 = change.getNewValue();
                if (newValue9 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                objArr11[0] = (Integer) newValue9;
                objArr10[0] = StringResourceUtilsKt.getQuantityString(resources2, context, R$plurals.guild_settings_audit_log_member_prune_delete_days_newValue, iIntValue, objArr11);
                return b.h(context, textId, objArr10, null, 4);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_VIDEO_QUALITY_MODE)) {
                Object[] objArr12 = new Object[1];
                MediaSinkWantsManager$VideoQualityMode$a mediaSinkWantsManager$VideoQualityMode$a = MediaSinkWantsManager$VideoQualityMode.Companion;
                Object newValue10 = change.getNewValue();
                if (newValue10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr12[0] = getStringForVideoQualityMode(mediaSinkWantsManager$VideoQualityMode$a.a(Integer.valueOf((int) ((Long) newValue10).longValue())), context);
                return b.h(context, textId, objArr12, null, 4);
            }
            if (!hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_GUILD_COMMUNICATION_DISABLED)) {
                return b.b(context, textId, new Object[0], new AuditLogChangeUtils$getChangeTextWithParams$1(change));
            }
            Object[] objArr13 = new Object[1];
            Object newValue11 = change.getNewValue();
            if (newValue11 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            objArr13[0] = TimeUtils.getReadableTimeString(context, (String) newValue11);
            return b.h(context, textId, objArr13, null, 4);
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getLocalizedMessage() + " for change: ");
            sb.append(change.getKey() + ' ' + change.getNewValue() + ' ' + change.getOldValue());
            String string = sb.toString();
            m.checkNotNullExpressionValue(string, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.w$default(AppLog.g, string, null, 2, null);
            return "";
        } catch (MissingFormatArgumentException unused) {
            StringBuilder sbU = a.U("Failed to get string for action id: ");
            sbU.append(auditLogEntry.getActionTypeId() + " and change: " + change.getKey());
            String string2 = sbU.toString();
            m.checkNotNullExpressionValue(string2, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.e$default(AppLog.g, "Audit Logs", string2, null, null, 12, null);
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getChannelChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1920783726:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REGION_OVERRIDE)) {
                        return getNullableNewOrOldValueString$default(this, change, 2131890838, 2131890839, 2131890840, null, 8, null);
                    }
                    break;
                case -1451708889:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_VIDEO_QUALITY_MODE)) {
                        return getNullableOldValueString(change, 2131890852, 2131890851);
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return 2131890858;
                    }
                    break;
                case -102270099:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_BITRATE)) {
                        return getNullableOldValueString(change, 2131890818, 2131890817);
                    }
                    break;
                case 3079692:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                        return 2131890831;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, 2131890825, 2131890824);
                    }
                    break;
                case 3390806:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NSFW)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (!zBooleanValue) {
                            return 2131890826;
                        }
                        if (zBooleanValue) {
                            return 2131890827;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    break;
                case 3575610:
                    if (key.equals("type")) {
                        return getNullableOldValueString(change, 2131890847, 2131890846);
                    }
                    break;
                case 92906313:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                        return 2131890832;
                    }
                    break;
                case 108404047:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET)) {
                        return 2131890833;
                    }
                    break;
                case 110546223:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_TOPIC)) {
                        return getNullableNewOrOldValueString$default(this, change, 2131890843, 2131890845, 2131890844, null, 8, null);
                    }
                    break;
                case 747804969:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_POSITION)) {
                        return getNullableOldValueString(change, 2131890835, 2131890834);
                    }
                    break;
                case 987155184:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_RATE_LIMIT_PER_USER)) {
                        return getNullableOldValueString(change, 2131890837, 2131890836);
                    }
                    break;
                case 1702269315:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DEFAULT_AUTO_ARCHIVE_DURATION)) {
                        return getNullableOldValueString(change, 2131890821, 2131890820);
                    }
                    break;
            }
        }
        return 0;
    }

    @StringRes
    private final int getChannelTypeStringResIdFromValue(Integer value) {
        if (value != null && value.intValue() == 1) {
            return 2131888572;
        }
        if (value != null && value.intValue() == 3) {
            return 2131889801;
        }
        if (value != null && value.intValue() == 0) {
            return 2131896301;
        }
        if (value != null && value.intValue() == 2) {
            return 2131897153;
        }
        if (value != null && value.intValue() == 5) {
            return 2131893207;
        }
        if (value != null && value.intValue() == 6) {
            return 2131896008;
        }
        if (value != null && value.intValue() == 13) {
            return 2131895774;
        }
        if ((value != null && value.intValue() == 10) || ((value != null && value.intValue() == 11) || (value != null && value.intValue() == 12))) {
            return 2131896341;
        }
        return (value != null && value.intValue() == 4) ? 2131887463 : 0;
    }

    @StringRes
    private final int getEmojiChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            int iHashCode = key.hashCode();
            if (iHashCode != -934964668) {
                if (iHashCode == 3373707 && key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                    return getNullableOldValueString(change, 2131890866, 2131890865);
                }
            } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                return 2131890858;
            }
        }
        return 0;
    }

    @StringRes
    private final int getGuildChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        switch (key.hashCode()) {
            case -1907190207:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_BANNER_HASH) ? 2131890871 : 0;
            case -1724546052:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION)) {
                    return getNullableNewValueString(change, 2131890876, 2131890875);
                }
                return 0;
            case -1722022341:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_SYSTEM_CHANNEL_FLAGS) ? 2131890901 : 0;
            case -1705139351:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_EXPLICIT_CONTENT_FILTER)) {
                    return 0;
                }
                Object value = change.getValue();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue = (int) ((Long) value).longValue();
                if (iLongValue == GuildExplicitContentFilter.NONE.getApiValue()) {
                    return 2131890879;
                }
                if (iLongValue == GuildExplicitContentFilter.SOME.getApiValue()) {
                    return 2131890880;
                }
                return iLongValue == GuildExplicitContentFilter.ALL.getApiValue() ? 2131890878 : 0;
            case -1572429104:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_AFK_CHANNEL_ID)) {
                    return getNullableNewValueString(change, 2131890869, 2131890868);
                }
                return 0;
            case -1390796524:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_ICON_HASH) ? 2131890889 : 0;
            case -1100074521:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_SYSTEM_CHANNEL_ID)) {
                    return getNullableNewValueString(change, 2131890903, 2131890902);
                }
                return 0;
            case -934964668:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON) ? 2131890858 : 0;
            case -934795532:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_REGION) ? 2131890897 : 0;
            case -645093141:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_PREMIUM_PROGRESS_BAR_ENABLED)) {
                    return 0;
                }
                Object value2 = change.getValue();
                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue = ((Boolean) value2).booleanValue();
                if (zBooleanValue) {
                    return 2131890896;
                }
                if (zBooleanValue) {
                    throw new NoWhenBranchMatchedException();
                }
                return 2131890895;
            case -506227616:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_VERIFICATION_LEVEL)) {
                    return 0;
                }
                Object value3 = change.getValue();
                Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue2 = (int) ((Long) value3).longValue();
                if (iLongValue2 == GuildVerificationLevel.NONE.getApiValue()) {
                    return 2131890916;
                }
                if (iLongValue2 == GuildVerificationLevel.LOW.getApiValue()) {
                    return 2131890914;
                }
                if (iLongValue2 == GuildVerificationLevel.MEDIUM.getApiValue()) {
                    return 2131890915;
                }
                if (iLongValue2 == GuildVerificationLevel.HIGH.getApiValue()) {
                    return 2131890913;
                }
                return iLongValue2 == GuildVerificationLevel.HIGHEST.getApiValue() ? 2131890917 : 0;
            case -154917112:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_AFK_TIMEOUT) ? 2131890870 : 0;
            case 3373707:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME) ? 2131890892 : 0;
            case 226923479:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_DISCOVERY_SPLASH_HASH) ? 2131890877 : 0;
            case 643741670:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_SPLASH_HASH) ? 2131890900 : 0;
            case 706006559:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_RULES_CHANNEL_ID)) {
                    return getNullableNewValueString(change, 2131890899, 2131890898);
                }
                return 0;
            case 945133165:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_MFA_LEVEL)) {
                    return 0;
                }
                Object value4 = change.getValue();
                Objects.requireNonNull(value4, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue3 = (int) ((Long) value4).longValue();
                if (iLongValue3 != 0) {
                    return iLongValue3 != 1 ? 0 : 2131890891;
                }
                return 2131890890;
            case 950953474:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_UPDATES_CHANNEL_ID)) {
                    return getNullableNewValueString(change, 2131890910, 2131890909);
                }
                return 0;
            case 1207357234:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_DEFAULT_MESSAGE_NOTIFICATIONS)) {
                    return 0;
                }
                Object value5 = change.getValue();
                Objects.requireNonNull(value5, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue4 = (int) ((Long) value5).longValue();
                if (iLongValue4 != 0) {
                    return iLongValue4 != 1 ? 0 : 2131890874;
                }
                return 2131890873;
            case 1580684753:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_VANITY_URL_CODE)) {
                    return getNullableNewValueString(change, 2131890912, 2131890911);
                }
                return 0;
            case 1639242418:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_WIDGET_CHANNEL_ID)) {
                    return getNullableNewValueString(change, 2131890919, 2131890918);
                }
                return 0;
            case 1663147559:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_OWNER_ID) ? 2131890893 : 0;
            case 1792613336:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_PREFERRED_LOCALE) ? 2131890894 : 0;
            case 2010777670:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_WIDGET_ENABLED)) {
                    return 0;
                }
                Object value6 = change.getValue();
                Objects.requireNonNull(value6, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue2 = ((Boolean) value6).booleanValue();
                if (zBooleanValue2) {
                    return 2131890921;
                }
                if (zBooleanValue2) {
                    throw new NoWhenBranchMatchedException();
                }
                return 2131890920;
            default:
                return 0;
        }
    }

    @StringRes
    private final int getGuildScheduledEventChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        switch (key.hashCode()) {
            case -1930808873:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                    return getNullableNewValueString(change, 2131890984, 2131890983);
                }
                return 0;
            case -1724546052:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION) ? 2131890987 : 0;
            case -1443139214:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_IMAGE_HASH)) {
                    return getNullableNewValueString(change, 2131890993, 2131890992);
                }
                return 0;
            case -892481550:
                if (!key.equals("status")) {
                    return 0;
                }
                Object value = change.getValue();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue = (int) ((Long) value).longValue();
                if (iLongValue == GuildScheduledEventStatus.SCHEDULED.getApiValue()) {
                    return 2131891000;
                }
                if (iLongValue == GuildScheduledEventStatus.ACTIVE.getApiValue()) {
                    return 2131890997;
                }
                if (iLongValue == GuildScheduledEventStatus.COMPLETED.getApiValue()) {
                    return 2131890999;
                }
                return iLongValue == GuildScheduledEventStatus.CANCELED.getApiValue() ? 2131890998 : 0;
            case 3373707:
                return key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME) ? 2131890996 : 0;
            case 1281710614:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_ENTITY_TYPE)) {
                    return 0;
                }
                Object value2 = change.getValue();
                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue2 = (int) ((Long) value2).longValue();
                if (iLongValue2 == GuildScheduledEventEntityType.NONE.getApiValue()) {
                    return 2131890989;
                }
                if (iLongValue2 == GuildScheduledEventEntityType.STAGE_INSTANCE.getApiValue()) {
                    return 2131890990;
                }
                if (iLongValue2 == GuildScheduledEventEntityType.VOICE.getApiValue()) {
                    return 2131890991;
                }
                return iLongValue2 == GuildScheduledEventEntityType.EXTERNAL.getApiValue() ? 2131890988 : 0;
            case 1901043637:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_LOCATION)) {
                    return getNullableNewValueString(change, 2131890995, 2131890994);
                }
                return 0;
            case 1965579277:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_PRIVACY_LEVEL)) {
                    return 0;
                }
                Object value3 = change.getValue();
                Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue3 = (int) ((Long) value3).longValue();
                if (iLongValue3 == StageInstancePrivacyLevel.GUILD_ONLY.getApiValue()) {
                    return 2131891005;
                }
                return iLongValue3 == StageInstancePrivacyLevel.PUBLIC.getApiValue() ? 2131891006 : 0;
            default:
                return 0;
        }
    }

    @StringRes
    private final int getIntegrationChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        int iHashCode = key.hashCode();
        if (iHashCode != -1743820047) {
            if (iHashCode != -486786702) {
                return (iHashCode == 1767574344 && key.equals(ModelAuditLogEntry.CHANGE_KEY_EXPIRE_GRACE_PERIOD)) ? 2131890928 : 0;
            }
            if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_EXPIRE_BEHAVIOR)) {
                return 0;
            }
            Object value = change.getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
            int iLongValue = (int) ((Long) value).longValue();
            if (iLongValue != 0) {
                return iLongValue != 1 ? 0 : 2131890926;
            }
            return 2131890927;
        }
        if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_ENABLE_EMOTICONS)) {
            return 0;
        }
        Object value2 = change.getValue();
        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) value2).booleanValue();
        if (zBooleanValue) {
            return 2131890925;
        }
        if (zBooleanValue) {
            throw new NoWhenBranchMatchedException();
        }
        return 2131890924;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getInviteChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1930808873:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                        return 2131890930;
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return 2131890858;
                    }
                    break;
                case 3059181:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                        return 2131890931;
                    }
                    break;
                case 408141255:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MAX_USES)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                        return ((int) ((Long) value).longValue()) != 0 ? 2131890936 : 2131890937;
                    }
                    break;
                case 844430244:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MAX_AGE)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                        return ((int) ((Long) value2).longValue()) != 0 ? 2131890934 : 2131890935;
                    }
                    break;
                case 1984986705:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_TEMPORARY)) {
                        Object value3 = change.getValue();
                        Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value3).booleanValue();
                        if (zBooleanValue) {
                            return 2131890939;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return 2131890938;
                    }
                    break;
            }
        }
        return 0;
    }

    private final int getNullableNewOrOldValueString(ModelAuditLogEntry$Change modelAuditLogEntry$Change, @StringRes Integer num, @StringRes Integer num2, @StringRes Integer num3, @StringRes Integer num4) {
        if (modelAuditLogEntry$Change.getNewValue() == null || modelAuditLogEntry$Change.getOldValue() == null) {
            if (modelAuditLogEntry$Change.getNewValue() != null) {
                num = num2;
            } else {
                num = modelAuditLogEntry$Change.getOldValue() != null ? num3 : num4;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static /* synthetic */ int getNullableNewOrOldValueString$default(AuditLogChangeUtils auditLogChangeUtils, ModelAuditLogEntry$Change modelAuditLogEntry$Change, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        return auditLogChangeUtils.getNullableNewOrOldValueString(modelAuditLogEntry$Change, (i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    private final int getNullableNewValueString(ModelAuditLogEntry$Change modelAuditLogEntry$Change, @StringRes int i, @StringRes int i2) {
        return modelAuditLogEntry$Change.getNewValue() == null ? i : i2;
    }

    private final int getNullableOldValueString(ModelAuditLogEntry$Change modelAuditLogEntry$Change, @StringRes int i, @StringRes int i2) {
        return modelAuditLogEntry$Change.getOldValue() == null ? i : i2;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    private final String getOverridesPluralString(Context context, ModelAuditLogEntry$Change change, ModelAuditLogEntry entry, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        CharSequence roleName;
        Object value = change.getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.Collection<*>");
        Collection collection = (Collection) value;
        ModelAuditLogEntry$Options options = entry.getOptions();
        Integer numValueOf = options != null ? Integer.valueOf(options.getType()) : null;
        Object objH = "";
        if (numValueOf != null && numValueOf.intValue() == 1) {
            Map<Long, ? extends CharSequence> map = targets.get(ModelAuditLogEntry$TargetType.USER);
            if (map != null) {
                ModelAuditLogEntry$Options options2 = entry.getOptions();
                roleName = map.get(options2 != null ? Long.valueOf(options2.getId()) : null);
            } else {
                roleName = null;
            }
        } else if (numValueOf != null && numValueOf.intValue() == 0) {
            ModelAuditLogEntry$Options options3 = entry.getOptions();
            if (options3 != null) {
                roleName = options3.getRoleName();
            } else {
                roleName = null;
            }
        } else {
            roleName = "";
        }
        String key = change.getKey();
        if (key != null) {
            int iHashCode = key.hashCode();
            if (iHashCode != 3079692) {
                if (iHashCode != 92906313) {
                    if (iHashCode == 108404047 && key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET)) {
                        Resources resources = context.getResources();
                        m.checkNotNullExpressionValue(resources, "context.resources");
                        objH = b.h(context, 2131890833, new Object[]{StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.guild_settings_audit_log_channel_permission_overrides_reset_count, collection.size(), Integer.valueOf(collection.size())), roleName}, null, 4);
                    }
                } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                    Resources resources2 = context.getResources();
                    m.checkNotNullExpressionValue(resources2, "context.resources");
                    objH = b.h(context, 2131890832, new Object[]{StringResourceUtilsKt.getQuantityString(resources2, context, R$plurals.guild_settings_audit_log_channel_permission_overrides_granted_count, collection.size(), Integer.valueOf(collection.size())), roleName}, null, 4);
                }
            } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                Resources resources3 = context.getResources();
                m.checkNotNullExpressionValue(resources3, "context.resources");
                objH = b.h(context, 2131890831, new Object[]{StringResourceUtilsKt.getQuantityString(resources3, context, R$plurals.guild_settings_audit_log_channel_permission_overrides_denied_count, collection.size(), Integer.valueOf(collection.size())), roleName}, null, 4);
            }
        }
        return objH.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final CharSequence getPluralString(Context context, ModelAuditLogEntry$Change change) {
        Object value = change.getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.Collection<*>");
        Collection collection = (Collection) value;
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case 1168893:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_ADD)) {
                        Resources resources = context.getResources();
                        m.checkNotNullExpressionValue(resources, "context.resources");
                        return StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.guild_settings_audit_log_member_roles_add_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
                case 3079692:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                        Resources resources2 = context.getResources();
                        m.checkNotNullExpressionValue(resources2, "context.resources");
                        return StringResourceUtilsKt.getQuantityString(resources2, context, R$plurals.guild_settings_audit_log_channel_permission_overrides_denied_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
                case 92906313:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                        Resources resources3 = context.getResources();
                        m.checkNotNullExpressionValue(resources3, "context.resources");
                        return StringResourceUtilsKt.getQuantityString(resources3, context, R$plurals.guild_settings_audit_log_channel_permission_overrides_granted_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
                case 950750632:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_REMOVE)) {
                        Resources resources4 = context.getResources();
                        m.checkNotNullExpressionValue(resources4, "context.resources");
                        return StringResourceUtilsKt.getQuantityString(resources4, context, R$plurals.guild_settings_audit_log_member_roles_remove_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
            }
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getRoleChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1390796524:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ICON_HASH)) {
                        return 2131890974;
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return 2131890858;
                    }
                    break;
                case 3079692:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                        return 2131890979;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, 2131890978, 2131890977);
                    }
                    break;
                case 64859716:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MENTIONABLE)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (zBooleanValue) {
                            return 2131890976;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return 2131890975;
                    }
                    break;
                case 92906313:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                        return 2131890980;
                    }
                    break;
                case 94842723:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_COLOR)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                        return ((Long) value2).longValue() == 0 ? 2131890969 : 2131890967;
                    }
                    break;
                case 99457571:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_HOIST)) {
                        Object value3 = change.getValue();
                        Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) value3).booleanValue();
                        if (zBooleanValue2) {
                            return 2131890973;
                        }
                        if (zBooleanValue2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return 2131890972;
                    }
                    break;
                case 1052836964:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_UNICODE_EMOJI)) {
                        return 2131890981;
                    }
                    break;
            }
        }
        return 0;
    }

    @StringRes
    private final int getStageInstanceChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        int iHashCode = key.hashCode();
        if (iHashCode == 110546223) {
            if (key.equals(ModelAuditLogEntry.CHANGE_KEY_TOPIC)) {
                return getNullableOldValueString(change, 2131890845, 2131890843);
            }
            return 0;
        }
        if (iHashCode != 1965579277 || !key.equals(ModelAuditLogEntry.CHANGE_KEY_PRIVACY_LEVEL)) {
            return 0;
        }
        Object value = change.getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
        int iLongValue = (int) ((Long) value).longValue();
        if (iLongValue == StageInstancePrivacyLevel.GUILD_ONLY.getApiValue()) {
            return 2131891005;
        }
        return iLongValue == StageInstancePrivacyLevel.PUBLIC.getApiValue() ? 2131891006 : 0;
    }

    @StringRes
    private final int getStickerChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            int iHashCode = key.hashCode();
            if (iHashCode != -1724546052) {
                if (iHashCode != 3373707) {
                    if (iHashCode == 3552281 && key.equals(ModelAuditLogEntry.CHANGE_KEY_TAGS)) {
                        return getNullableOldValueString(change, 2131891012, 2131891011);
                    }
                } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                    return getNullableOldValueString(change, 2131890965, 2131890964);
                }
            } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION)) {
                return getNullableOldValueString(change, 2131890862, 2131890861);
            }
        }
        return 0;
    }

    @StringRes
    private final int getStringForPermission(long permission, ModelAuditLogEntry log) {
        if (permission == 1) {
            return 2131888237;
        }
        if (permission == 2) {
            return 2131892497;
        }
        if (permission == 4) {
            return 2131887002;
        }
        if (permission == 8) {
            return 2131886371;
        }
        if (permission == 16) {
            return (log.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL || log.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE) ? 2131892676 : 2131892678;
        }
        if (permission == 32) {
            return 2131892693;
        }
        if (permission == Permission.VIEW_GUILD_ANALYTICS) {
            return 2131897135;
        }
        if (permission == Permission.CHANGE_NICKNAME) {
            return 2131887522;
        }
        if (permission == Permission.MANAGE_NICKNAMES) {
            return 2131892686;
        }
        if (permission == Permission.MANAGE_ROLES) {
            return 2131892691;
        }
        if (permission == Permission.MANAGE_WEBHOOKS) {
            return 2131892699;
        }
        if (permission == Permission.MANAGE_EMOJIS_AND_STICKERS) {
            return 2131892680;
        }
        if (permission == Permission.MANAGE_EVENTS) {
            return 2131892681;
        }
        if (permission == 128) {
            return 2131897130;
        }
        if (permission == Permission.VIEW_CHANNEL) {
            return 2131894703;
        }
        if (permission == Permission.SEND_MESSAGES) {
            return 2131895427;
        }
        if (permission == Permission.SEND_TTS_MESSAGES) {
            return 2131895433;
        }
        if (permission == Permission.MANAGE_MESSAGES) {
            return 2131892684;
        }
        if (permission == Permission.EMBED_LINKS) {
            return 2131888663;
        }
        if (permission == Permission.ATTACH_FILES) {
            return 2131886867;
        }
        if (permission == Permission.READ_MESSAGE_HISTORY) {
            return 2131894702;
        }
        if (permission == Permission.MENTION_EVERYONE) {
            return 2131892941;
        }
        if (permission == Permission.USE_EXTERNAL_EMOJIS) {
            return 2131896700;
        }
        if (permission == Permission.USE_EXTERNAL_STICKERS) {
            return 2131895122;
        }
        if (permission == 64) {
            return 2131886360;
        }
        if (permission == Permission.CONNECT) {
            return 2131887831;
        }
        if (permission == Permission.SPEAK) {
            return 2131895738;
        }
        if (permission == Permission.MUTE_MEMBERS) {
            return 2131893150;
        }
        if (permission == Permission.DEAFEN_MEMBERS) {
            return 2131888356;
        }
        if (permission == Permission.MOVE_MEMBERS) {
            return 2131893080;
        }
        if (permission == Permission.USE_VAD) {
            return 2131896708;
        }
        if (permission == 256) {
            return 2131894535;
        }
        if (permission == 512) {
            return R$string.video;
        }
        if (permission == Permission.USE_APPLICATION_COMMANDS) {
            return 2131896695;
        }
        if (permission == Permission.REQUEST_TO_SPEAK) {
            return 2131894806;
        }
        if (permission == Permission.SEND_MESSAGES_IN_THREADS) {
            return 2131895431;
        }
        if (permission == Permission.CREATE_PUBLIC_THREADS) {
            return 2131888241;
        }
        if (permission == Permission.CREATE_PRIVATE_THREADS) {
            return 2131888240;
        }
        if (permission == Permission.MANAGE_THREADS) {
            return 2131892695;
        }
        return permission == Permission.MODERATE_MEMBERS ? 2131893062 : 0;
    }

    private final CharSequence getStringForVideoQualityMode(MediaSinkWantsManager$VideoQualityMode mode, Context context) {
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            return b.h(context, 2131897117, new Object[0], null, 4);
        }
        if (iOrdinal == 1) {
            return b.h(context, 2131897118, new Object[0], null, 4);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getTextColor(Context context, ModelAuditLogEntry auditLogEntry) {
        ModelAuditLogEntry$ActionType actionType = auditLogEntry.getActionType();
        if (actionType != null) {
            int iOrdinal = actionType.ordinal();
            if (iOrdinal == 1) {
                return ColorCompat.getColor(context, 2131100298);
            }
            if (iOrdinal == 2) {
                return ColorCompat.getColor(context, 2131100407);
            }
            if (iOrdinal == 3) {
                return ColorCompat.getColor(context, 2131100379);
            }
        }
        return ColorCompat.getColor(context, 2131100171);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getThreadChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1716307998:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ARCHIVED)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (zBooleanValue) {
                            return 2131891013;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return 2131891024;
                    }
                    break;
                case -1097452790:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_LOCKED)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) value2).booleanValue();
                        if (zBooleanValue2) {
                            return 2131891021;
                        }
                        if (zBooleanValue2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return 2131891025;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, 2131891023, 2131891022);
                    }
                    break;
                case 987155184:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_RATE_LIMIT_PER_USER)) {
                        return getNullableOldValueString(change, 2131890837, 2131890836);
                    }
                    break;
                case 1901007105:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION)) {
                        return getNullableOldValueString(change, 2131891015, 2131891014);
                    }
                    break;
            }
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getUserChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1919744682:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PRUNE_DELETE_DAYS)) {
                        return 2131890955;
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return 2131890858;
                    }
                    break;
                case 1168893:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_ADD)) {
                        return 2131890957;
                    }
                    break;
                case 3079270:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DEAF)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (zBooleanValue) {
                            return 2131890945;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return 2131890944;
                    }
                    break;
                case 3363353:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MUTE)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) value2).booleanValue();
                        if (zBooleanValue2) {
                            return 2131890950;
                        }
                        if (zBooleanValue2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return 2131890949;
                    }
                    break;
                case 3381091:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NICK)) {
                        return getNullableNewOrOldValueString$default(this, change, 2131890951, 2131890952, 2131890953, null, 8, null);
                    }
                    break;
                case 950750632:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_REMOVE)) {
                        return 2131890958;
                    }
                    break;
                case 1217496932:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_COMMUNICATION_DISABLED)) {
                        return getNullableNewValueString(change, 2131890860, 2131890859);
                    }
                    break;
            }
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getWebhookChangeString(ModelAuditLogEntry$Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1930808873:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                        return getNullableOldValueString(change, 2131891042, 2131891041);
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return 2131890858;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, 2131891046, 2131891045);
                    }
                    break;
                case 396929076:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_AVATAR_HASH)) {
                        return 2131891040;
                    }
                    break;
            }
        }
        return 0;
    }

    private final boolean hasNewValue(ModelAuditLogEntry$Change modelAuditLogEntry$Change, String str) {
        return modelAuditLogEntry$Change.getNewValue() != null && m.areEqual(modelAuditLogEntry$Change.getKey(), str);
    }

    private final String renderPermissionList(ModelAuditLogEntry$Change change, ModelAuditLogEntry auditLogEntry, Context context) {
        Object value = change.getValue();
        if (!(value instanceof Set)) {
            value = null;
        }
        Set set = (Set) value;
        return set != null ? q.joinToString$default(q.filterNot(q.map(q.filter(q.mapNotNull(q.sorted(u.asSequence(set)), new AuditLogChangeUtils$renderPermissionList$1(auditLogEntry)), AuditLogChangeUtils$renderPermissionList$2.INSTANCE), new AuditLogChangeUtils$renderPermissionList$3(context)), AuditLogChangeUtils$renderPermissionList$4.INSTANCE), null, null, null, 0, null, null, 63, null) : "";
    }

    private final String renderPermissions(ModelAuditLogEntry$Change change, ModelAuditLogEntry auditLogEntry, Context context, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        return getOverridesPluralString(context, change, auditLogEntry, targets) + "\n" + renderPermissionList(change, auditLogEntry, context);
    }

    private final String renderRoles(Context context, ModelAuditLogEntry$Change change) {
        String string = getPluralString(context, change).toString() + "\n";
        Object newValue = change.getNewValue();
        Objects.requireNonNull(newValue, "null cannot be cast to non-null type kotlin.collections.List<com.discord.models.domain.ModelAuditLogEntry.ChangeNameId>");
        boolean z2 = false;
        for (ModelAuditLogEntry$ChangeNameId modelAuditLogEntry$ChangeNameId : (List) newValue) {
            if (z2) {
                string = a.w(string, ", ");
            } else {
                z2 = true;
            }
            StringBuilder sbU = a.U(string);
            sbU.append(modelAuditLogEntry$ChangeNameId.getName());
            string = sbU.toString();
        }
        return string;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final boolean shouldNotRenderChange(ModelAuditLogEntry auditLogEntry, ModelAuditLogEntry$Change change) {
        String key;
        if (auditLogEntry.getActionType() != ModelAuditLogEntry$ActionType.DELETE || RENDERABLE_DELETE_ACTION_TYPES.contains(Integer.valueOf(auditLogEntry.getActionTypeId()))) {
            if (auditLogEntry.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL) {
                String key2 = change.getKey();
                if (key2 == null) {
                    return false;
                }
                int iHashCode = key2.hashCode();
                if (iHashCode != 3355) {
                    if (iHashCode != 852040376 || !key2.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSION_OVERWRITES)) {
                        return false;
                    }
                } else if (!key2.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                    return false;
                }
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE) {
                String key3 = change.getKey();
                if (key3 == null) {
                    return false;
                }
                int iHashCode2 = key3.hashCode();
                if (iHashCode2 != 3355) {
                    if (iHashCode2 != 3575610) {
                        if (iHashCode2 != 852040376 || !key3.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSION_OVERWRITES)) {
                            return false;
                        }
                    } else if (!key3.equals("type")) {
                        return false;
                    }
                } else if (!key3.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                    return false;
                }
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry$TargetType.INVITE) {
                String key4 = change.getKey();
                if (key4 == null) {
                    return false;
                }
                int iHashCode3 = key4.hashCode();
                if (iHashCode3 != 3599308) {
                    if (iHashCode3 != 1198966417 || !key4.equals(ModelAuditLogEntry.CHANGE_KEY_INVITER_ID)) {
                        return false;
                    }
                } else if (!key4.equals(ModelAuditLogEntry.CHANGE_KEY_USES)) {
                    return false;
                }
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry$TargetType.WEBHOOK) {
                String key5 = change.getKey();
                if (key5 == null) {
                    return false;
                }
                int iHashCode4 = key5.hashCode();
                if (iHashCode4 != -1287148950) {
                    if (iHashCode4 != 3575610 || !key5.equals("type")) {
                        return false;
                    }
                } else if (!key5.equals(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID)) {
                    return false;
                }
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry$TargetType.INTEGRATION) {
                String key6 = change.getKey();
                if (key6 == null || key6.hashCode() != 3575610 || !key6.equals("type")) {
                    return false;
                }
            } else {
                if (auditLogEntry.getTargetType() != ModelAuditLogEntry$TargetType.STICKER || (key = change.getKey()) == null) {
                    return false;
                }
                switch (key.hashCode()) {
                    case -1724546052:
                        if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION)) {
                            return t.isBlank(change.getValue().toString());
                        }
                        return false;
                    case -1306538777:
                        if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                            return false;
                        }
                        break;
                    case -733902135:
                        if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_AVAILABLE)) {
                            return false;
                        }
                        break;
                    case 3355:
                        if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                            return false;
                        }
                        break;
                    case 3575610:
                        if (!key.equals("type")) {
                            return false;
                        }
                        break;
                    case 93121264:
                        if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_ASSET)) {
                            return false;
                        }
                        break;
                    case 1458614914:
                        if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_FORMAT_TYPE)) {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009c  */
    public final CharSequence getChangeSummary(Context context, ModelAuditLogEntry auditLogEntry, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        int i;
        int iOrdinal;
        int guildChangeString;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(auditLogEntry, "auditLogEntry");
        m.checkNotNullParameter(targets, "targets");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Typeface typefaceCreate = Typeface.create(FontUtils.INSTANCE.getThemedFont(context, 2130969393), 0);
        List<ModelAuditLogEntry$Change> changes = auditLogEntry.getChanges();
        if (changes != null) {
            int i2 = 0;
            for (ModelAuditLogEntry$Change modelAuditLogEntry$Change : changes) {
                AuditLogChangeUtils auditLogChangeUtils = INSTANCE;
                m.checkNotNullExpressionValue(modelAuditLogEntry$Change, "change");
                if (!auditLogChangeUtils.shouldNotRenderChange(auditLogEntry, modelAuditLogEntry$Change)) {
                    ModelAuditLogEntry$TargetType targetType = auditLogEntry.getTargetType();
                    if (targetType != null && (iOrdinal = targetType.ordinal()) != 0) {
                        switch (iOrdinal) {
                            case 2:
                                guildChangeString = auditLogChangeUtils.getGuildChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 3:
                            case 4:
                                guildChangeString = auditLogChangeUtils.getChannelChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 5:
                                guildChangeString = auditLogChangeUtils.getUserChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 6:
                                guildChangeString = auditLogChangeUtils.getRoleChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 7:
                                guildChangeString = auditLogChangeUtils.getInviteChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 8:
                                guildChangeString = auditLogChangeUtils.getWebhookChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 9:
                                guildChangeString = auditLogChangeUtils.getEmojiChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 10:
                                guildChangeString = auditLogChangeUtils.getIntegrationChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 11:
                                guildChangeString = auditLogChangeUtils.getStageInstanceChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 12:
                                guildChangeString = auditLogChangeUtils.getGuildScheduledEventChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 13:
                                guildChangeString = auditLogChangeUtils.getStickerChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            case 14:
                                guildChangeString = auditLogChangeUtils.getThreadChangeString(modelAuditLogEntry$Change);
                                i = guildChangeString;
                                break;
                            default:
                                i = 0;
                                break;
                        }
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        int i3 = i2 + 1;
                        if (i3 != 1) {
                            spannableStringBuilder.append((CharSequence) "\n");
                        }
                        int iMax = Math.max(spannableStringBuilder.length() - 1, 0);
                        spannableStringBuilder.append((CharSequence) (auditLogChangeUtils.getChangeNumberString(i3) + " — "));
                        int length = spannableStringBuilder.length() - 1;
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(auditLogChangeUtils.getTextColor(context, auditLogEntry)), iMax, length, 33);
                        m.checkNotNullExpressionValue(typefaceCreate, "numberTypeface");
                        spannableStringBuilder.setSpan(new TypefaceSpanCompat(typefaceCreate), iMax, length, 33);
                        spannableStringBuilder.append(b.l(auditLogChangeUtils.getChangeTextWithParams(context, auditLogEntry, modelAuditLogEntry$Change, i, targets), new Object[0], null, 2));
                        if (m.areEqual(modelAuditLogEntry$Change.getKey(), ModelAuditLogEntry.CHANGE_KEY_COLOR) && modelAuditLogEntry$Change.getValue() != null) {
                            Object value = modelAuditLogEntry$Change.getValue();
                            Long l = (Long) (value instanceof Long ? value : null);
                            if (l == null || l.longValue() != 0) {
                                spannableStringBuilder.append((CharSequence) "●");
                                Object value2 = modelAuditLogEntry$Change.getValue();
                                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                                String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & ((int) ((Long) value2).longValue()))}, 1));
                                m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str)), w.getLastIndex(spannableStringBuilder), w.getLastIndex(spannableStringBuilder) + 1, 33);
                            }
                        }
                        i2 = i3;
                    } else {
                        AppLog appLog = AppLog.g;
                        StringBuilder sbU = a.U("No change text for actiontype: ");
                        sbU.append(auditLogEntry.getActionTypeId());
                        sbU.append(" key:");
                        sbU.append(modelAuditLogEntry$Change.getKey());
                        Logger.w$default(appLog, "Audit Logs", sbU.toString(), null, 4, null);
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    public final boolean hasChangesToRender(ModelAuditLogEntry log) {
        boolean z2;
        m.checkNotNullParameter(log, "log");
        List<ModelAuditLogEntry$Change> changes = log.getChanges();
        if (changes == null) {
            return false;
        }
        if (changes.isEmpty()) {
            z2 = false;
        } else {
            for (ModelAuditLogEntry$Change modelAuditLogEntry$Change : changes) {
                AuditLogChangeUtils auditLogChangeUtils = INSTANCE;
                m.checkNotNullExpressionValue(modelAuditLogEntry$Change, "it");
                if (!auditLogChangeUtils.shouldNotRenderChange(log, modelAuditLogEntry$Change)) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public final List<ModelAuditLogEntry$Change> transformPermissionChange(ModelAuditLogEntry$Change change) {
        m.checkNotNullParameter(change, "change");
        Pair<HashSet<Long>, HashSet<Long>> pairCalculatePermissionChange = calculatePermissionChange(change);
        ArrayList arrayList = new ArrayList();
        if (!pairCalculatePermissionChange.getFirst().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry$Change(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, null, pairCalculatePermissionChange.getFirst()));
        }
        if (!pairCalculatePermissionChange.getSecond().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry$Change(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED, null, pairCalculatePermissionChange.getSecond()));
        }
        return arrayList;
    }

    public final List<ModelAuditLogEntry$Change> transformPermissionOverride(ModelAuditLogEntry$Change change) {
        m.checkNotNullParameter(change, "change");
        Pair<HashSet<Long>, HashSet<Long>> pairCalculatePermissionChange = calculatePermissionChange(change);
        ArrayList arrayList = new ArrayList();
        if (!pairCalculatePermissionChange.getFirst().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry$Change(change.getKey(), null, pairCalculatePermissionChange.getFirst()));
        }
        if (!pairCalculatePermissionChange.getSecond().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry$Change(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, null, pairCalculatePermissionChange.getSecond()));
        }
        return arrayList;
    }
}
