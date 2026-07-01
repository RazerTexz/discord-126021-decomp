package com.discord.utilities.auditlogs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.app.AppLog;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.time.TimeUtils;
import d0.f0._Sequences2;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuditLogChangeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogChangeUtils {
    public static final AuditLogChangeUtils INSTANCE = new AuditLogChangeUtils();
    private static final List<Integer> RENDERABLE_DELETE_ACTION_TYPES = Collections2.listOf((Object[]) new Integer[]{22, 20, 21});
    private static final List<String> CHANGE_KEYS_REFERENCING_CHANNEL = Collections2.listOf((Object[]) new String[]{ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_AFK_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_SYSTEM_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_RULES_CHANNEL_ID, ModelAuditLogEntry.CHANGE_KEY_UPDATES_CHANNEL_ID});

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ModelAuditLogEntry.TargetType.values();
            int[] iArr = new int[15];
            $EnumSwitchMapping$0 = iArr;
            iArr[ModelAuditLogEntry.TargetType.ALL.ordinal()] = 1;
            iArr[ModelAuditLogEntry.TargetType.GUILD.ordinal()] = 2;
            iArr[ModelAuditLogEntry.TargetType.CHANNEL.ordinal()] = 3;
            iArr[ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE.ordinal()] = 4;
            iArr[ModelAuditLogEntry.TargetType.USER.ordinal()] = 5;
            iArr[ModelAuditLogEntry.TargetType.ROLE.ordinal()] = 6;
            iArr[ModelAuditLogEntry.TargetType.INVITE.ordinal()] = 7;
            iArr[ModelAuditLogEntry.TargetType.WEBHOOK.ordinal()] = 8;
            iArr[ModelAuditLogEntry.TargetType.EMOJI.ordinal()] = 9;
            iArr[ModelAuditLogEntry.TargetType.STICKER.ordinal()] = 10;
            iArr[ModelAuditLogEntry.TargetType.INTEGRATION.ordinal()] = 11;
            iArr[ModelAuditLogEntry.TargetType.STAGE_INSTANCE.ordinal()] = 12;
            iArr[ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 13;
            iArr[ModelAuditLogEntry.TargetType.THREAD.ordinal()] = 14;
            MediaSinkWantsManager.VideoQualityMode.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MediaSinkWantsManager.VideoQualityMode.AUTO.ordinal()] = 1;
            iArr2[MediaSinkWantsManager.VideoQualityMode.FULL.ordinal()] = 2;
            ModelAuditLogEntry.ActionType.values();
            int[] iArr3 = new int[4];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ModelAuditLogEntry.ActionType.CREATE.ordinal()] = 1;
            iArr3[ModelAuditLogEntry.ActionType.UPDATE.ordinal()] = 2;
            iArr3[ModelAuditLogEntry.ActionType.DELETE.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auditlogs.AuditLogChangeUtils$renderPermissionList$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuditLogChangeUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Integer> {
        public final /* synthetic */ ModelAuditLogEntry $auditLogEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelAuditLogEntry modelAuditLogEntry) {
            super(1);
            this.$auditLogEntry = modelAuditLogEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Integer invoke(long j) {
            return Integer.valueOf(AuditLogChangeUtils.INSTANCE.getStringForPermission(j, this.$auditLogEntry));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auditlogs.AuditLogChangeUtils$renderPermissionList$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuditLogChangeUtils.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(int i) {
            return i != 0;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auditlogs.AuditLogChangeUtils$renderPermissionList$3, reason: invalid class name */
    /* JADX INFO: compiled from: AuditLogChangeUtils.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Integer, CharSequence> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            return FormatUtils.b(this.$context, i, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auditlogs.AuditLogChangeUtils$renderPermissionList$4, reason: invalid class name */
    /* JADX INFO: compiled from: AuditLogChangeUtils.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<CharSequence, Boolean> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CharSequence charSequence) {
            return Boolean.valueOf(invoke2(charSequence));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(charSequence, "it");
            return charSequence.length() == 0;
        }
    }

    private AuditLogChangeUtils() {
    }

    private final Tuples2<HashSet<Long>, HashSet<Long>> calculatePermissionChange(ModelAuditLogEntry.Change change) {
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
        return new Tuples2<>(hashSet, hashSet2);
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
    private final CharSequence getChangeTextWithParams(Context context, ModelAuditLogEntry auditLogEntry, ModelAuditLogEntry.Change change, @StringRes int textId, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        CharSequence charSequenceB;
        CharSequence charSequenceB2;
        try {
            if (hasNewValue(change, "type") && auditLogEntry.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL) {
                if (change.getOldValue() == null) {
                    charSequenceB = null;
                } else {
                    Object oldValue = change.getOldValue();
                    if (oldValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    int channelTypeStringResIdFromValue = getChannelTypeStringResIdFromValue(Integer.valueOf((int) ((Long) oldValue).longValue()));
                    if (channelTypeStringResIdFromValue != 0) {
                        charSequenceB = FormatUtils.b(context, channelTypeStringResIdFromValue, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
                    } else {
                        charSequenceB = null;
                    }
                }
                if (change.getNewValue() == null) {
                    charSequenceB2 = null;
                } else {
                    Object newValue = change.getNewValue();
                    if (newValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    int channelTypeStringResIdFromValue2 = getChannelTypeStringResIdFromValue(Integer.valueOf((int) ((Long) newValue).longValue()));
                    if (channelTypeStringResIdFromValue2 != 0) {
                        charSequenceB2 = FormatUtils.b(context, channelTypeStringResIdFromValue2, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
                    } else {
                        charSequenceB2 = null;
                    }
                }
                return (charSequenceB != null || charSequenceB2 == null) ? FormatUtils.b(context, textId, new Object[]{charSequenceB, charSequenceB2}, (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, textId, new Object[]{charSequenceB2}, (4 & 4) != 0 ? FormatUtils.b.j : null);
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
                Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
                objArr[0] = str;
                return FormatUtils.b(context, textId, objArr, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_MAX_AGE)) {
                Object[] objArr3 = new Object[1];
                Object newValue3 = change.getNewValue();
                if (newValue3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr3[0] = DurationUtils3.formatInviteExpireAfterString(context, (int) ((Long) newValue3).longValue());
                return FormatUtils.b(context, textId, objArr3, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (change.getNewValue() != null && auditLogEntry.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE && (Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED) || Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED) || Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET))) {
                return renderPermissions(change, auditLogEntry, context, targets);
            }
            if (change.getNewValue() != null && (Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED) || Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED))) {
                return FormatUtils.b(context, textId, new Object[]{getPluralString(context, change).toString() + "\n" + renderPermissionList(change, auditLogEntry, context)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (change.getNewValue() != null && (Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_ROLES_REMOVE) || Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_ROLES_ADD))) {
                return FormatUtils.b(context, textId, new Object[]{renderRoles(context, change)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (change.getNewValue() != null && CHANGE_KEYS_REFERENCING_CHANNEL.contains(change.getKey())) {
                Object[] objArr4 = new Object[1];
                Map<Long, ? extends CharSequence> map = targets.get(ModelAuditLogEntry.TargetType.CHANNEL);
                objArr4[0] = map != null ? map.get(Long.valueOf(Long.parseLong(change.getValue().toString()))) : null;
                return FormatUtils.b(context, textId, objArr4, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_BITRATE)) {
                Object[] objArr5 = new Object[1];
                Object newValue4 = change.getNewValue();
                if (newValue4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr5[0] = Long.valueOf(((Long) newValue4).longValue() / ((long) 1000));
                return FormatUtils.b(context, textId, objArr5, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_OWNER_ID)) {
                Object[] objArr6 = new Object[1];
                User user = StoreStream.INSTANCE.getUsers().getUsers().get(Long.valueOf(Long.parseLong(change.getNewValue().toString())));
                objArr6[0] = user != null ? user.getUsername() : null;
                return FormatUtils.b(context, textId, objArr6, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_RATE_LIMIT_PER_USER)) {
                Object[] objArr7 = new Object[1];
                Resources resources = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
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
                objArr7[0] = StringResourceUtils.getQuantityString(resources, context, R.plurals.guild_settings_audit_log_channel_rate_limit_per_user_change_newValue, iLongValue, objArr8);
                return FormatUtils.b(context, textId, objArr7, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_AFK_TIMEOUT)) {
                Object[] objArr9 = new Object[1];
                Object newValue7 = change.getNewValue();
                if (newValue7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr9[0] = Long.valueOf(((Long) newValue7).longValue() / ((long) 60));
                return FormatUtils.b(context, textId, objArr9, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_PRUNE_DELETE_DAYS)) {
                Object[] objArr10 = new Object[1];
                Resources resources2 = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "context.resources");
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
                objArr10[0] = StringResourceUtils.getQuantityString(resources2, context, R.plurals.guild_settings_audit_log_member_prune_delete_days_newValue, iIntValue, objArr11);
                return FormatUtils.b(context, textId, objArr10, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_VIDEO_QUALITY_MODE)) {
                Object[] objArr12 = new Object[1];
                MediaSinkWantsManager.VideoQualityMode.Companion companion = MediaSinkWantsManager.VideoQualityMode.INSTANCE;
                Object newValue10 = change.getNewValue();
                if (newValue10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                objArr12[0] = getStringForVideoQualityMode(companion.a(Integer.valueOf((int) ((Long) newValue10).longValue())), context);
                return FormatUtils.b(context, textId, objArr12, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (!hasNewValue(change, ModelAuditLogEntry.CHANGE_KEY_GUILD_COMMUNICATION_DISABLED)) {
                return FormatUtils.b(context, textId, new Object[0], new AnonymousClass1(change));
            }
            Object[] objArr13 = new Object[1];
            Object newValue11 = change.getNewValue();
            if (newValue11 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            objArr13[0] = TimeUtils.getReadableTimeString(context, (String) newValue11);
            return FormatUtils.b(context, textId, objArr13, (4 & 4) != 0 ? FormatUtils.b.j : null);
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getLocalizedMessage() + " for change: ");
            sb.append(change.getKey() + ' ' + change.getNewValue() + ' ' + change.getOldValue());
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.w$default(AppLog.g, string, null, 2, null);
            return "";
        } catch (MissingFormatArgumentException unused) {
            StringBuilder sbU = outline.U("Failed to get string for action id: ");
            sbU.append(auditLogEntry.getActionTypeId() + " and change: " + change.getKey());
            String string2 = sbU.toString();
            Intrinsics3.checkNotNullExpressionValue(string2, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.e$default(AppLog.g, "Audit Logs", string2, null, null, 12, null);
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getChannelChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1920783726:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REGION_OVERRIDE)) {
                        return getNullableNewOrOldValueString$default(this, change, Integer.valueOf(R.string.guild_settings_audit_log_channel_rtc_region_override_change), Integer.valueOf(R.string.guild_settings_audit_log_channel_rtc_region_override_create), Integer.valueOf(R.string.guild_settings_audit_log_channel_rtc_region_override_delete), null, 8, null);
                    }
                    break;
                case -1451708889:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_VIDEO_QUALITY_MODE)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_video_quality_mode_create, R.string.guild_settings_audit_log_channel_video_quality_mode_change);
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return R.string.guild_settings_audit_log_common_reason;
                    }
                    break;
                case -102270099:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_BITRATE)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_bitrate_create, R.string.guild_settings_audit_log_channel_bitrate_change);
                    }
                    break;
                case 3079692:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                        return R.string.guild_settings_audit_log_channel_permission_overrides_denied;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_name_create, R.string.guild_settings_audit_log_channel_name_change);
                    }
                    break;
                case 3390806:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NSFW)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (!zBooleanValue) {
                            return R.string.guild_settings_audit_log_channel_nsfw_disabled;
                        }
                        if (zBooleanValue) {
                            return R.string.guild_settings_audit_log_channel_nsfw_enabled;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    break;
                case 3575610:
                    if (key.equals("type")) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_type_create, R.string.guild_settings_audit_log_channel_type_change);
                    }
                    break;
                case 92906313:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                        return R.string.guild_settings_audit_log_channel_permission_overrides_granted;
                    }
                    break;
                case 108404047:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET)) {
                        return R.string.guild_settings_audit_log_channel_permission_overrides_reset;
                    }
                    break;
                case 110546223:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_TOPIC)) {
                        return getNullableNewOrOldValueString$default(this, change, Integer.valueOf(R.string.guild_settings_audit_log_channel_topic_change), Integer.valueOf(R.string.guild_settings_audit_log_channel_topic_create), Integer.valueOf(R.string.guild_settings_audit_log_channel_topic_clear), null, 8, null);
                    }
                    break;
                case 747804969:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_POSITION)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_position_create, R.string.guild_settings_audit_log_channel_position_change);
                    }
                    break;
                case 987155184:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_RATE_LIMIT_PER_USER)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_rate_limit_per_user_create, R.string.guild_settings_audit_log_channel_rate_limit_per_user_change);
                    }
                    break;
                case 1702269315:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DEFAULT_AUTO_ARCHIVE_DURATION)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_default_auto_archive_duration_create, R.string.guild_settings_audit_log_channel_default_auto_archive_duration_change);
                    }
                    break;
            }
        }
        return 0;
    }

    @StringRes
    private final int getChannelTypeStringResIdFromValue(Integer value) {
        if (value != null && value.intValue() == 1) {
            return R.string.dm;
        }
        if (value != null && value.intValue() == 3) {
            return R.string.group_dm;
        }
        if (value != null && value.intValue() == 0) {
            return R.string.text_channel;
        }
        if (value != null && value.intValue() == 2) {
            return R.string.voice_channel;
        }
        if (value != null && value.intValue() == 5) {
            return R.string.news_channel;
        }
        if (value != null && value.intValue() == 6) {
            return R.string.store_channel;
        }
        if (value != null && value.intValue() == 13) {
            return R.string.stage_channel;
        }
        if ((value != null && value.intValue() == 10) || ((value != null && value.intValue() == 11) || (value != null && value.intValue() == 12))) {
            return R.string.thread;
        }
        if (value != null && value.intValue() == 4) {
            return R.string.category;
        }
        return 0;
    }

    @StringRes
    private final int getEmojiChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            int iHashCode = key.hashCode();
            if (iHashCode != -934964668) {
                if (iHashCode == 3373707 && key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                    return getNullableOldValueString(change, R.string.guild_settings_audit_log_emoji_name_create, R.string.guild_settings_audit_log_emoji_name_change);
                }
            } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                return R.string.guild_settings_audit_log_common_reason;
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getGuildChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        switch (key.hashCode()) {
            case -1907190207:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_BANNER_HASH)) {
                    return R.string.guild_settings_audit_log_guild_banner_hash_change;
                }
                return 0;
            case -1724546052:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_guild_description_clear, R.string.guild_settings_audit_log_guild_description_change);
                }
                return 0;
            case -1722022341:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_SYSTEM_CHANNEL_FLAGS)) {
                    return R.string.guild_settings_audit_log_guild_system_channel_flags_change;
                }
                return 0;
            case -1705139351:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_EXPLICIT_CONTENT_FILTER)) {
                    return 0;
                }
                Object value = change.getValue();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue = (int) ((Long) value).longValue();
                if (iLongValue == GuildExplicitContentFilter.NONE.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_explicit_content_filter_disable;
                }
                if (iLongValue == GuildExplicitContentFilter.SOME.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_explicit_content_filter_members_without_roles;
                }
                if (iLongValue == GuildExplicitContentFilter.ALL.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_explicit_content_filter_all_members;
                }
                return 0;
            case -1572429104:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_AFK_CHANNEL_ID)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_guild_afk_channel_id_clear, R.string.guild_settings_audit_log_guild_afk_channel_id_change);
                }
                return 0;
            case -1390796524:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ICON_HASH)) {
                    return R.string.guild_settings_audit_log_guild_icon_hash_change;
                }
                return 0;
            case -1100074521:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_SYSTEM_CHANNEL_ID)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_guild_system_channel_id_disable, R.string.guild_settings_audit_log_guild_system_channel_id_change);
                }
                return 0;
            case -934964668:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                    return R.string.guild_settings_audit_log_common_reason;
                }
                return 0;
            case -934795532:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REGION)) {
                    return R.string.guild_settings_audit_log_guild_region_change;
                }
                return 0;
            case -645093141:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_PREMIUM_PROGRESS_BAR_ENABLED)) {
                    return 0;
                }
                Object value2 = change.getValue();
                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue = ((Boolean) value2).booleanValue();
                if (zBooleanValue) {
                    return R.string.guild_settings_audit_log_guild_premium_progress_bar_enabled_enabled;
                }
                if (zBooleanValue) {
                    throw new NoWhenBranchMatchedException();
                }
                return R.string.guild_settings_audit_log_guild_premium_progress_bar_enabled_disabled;
            case -506227616:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_VERIFICATION_LEVEL)) {
                    return 0;
                }
                Object value3 = change.getValue();
                Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue2 = (int) ((Long) value3).longValue();
                if (iLongValue2 == GuildVerificationLevel.NONE.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_verification_level_change_none;
                }
                if (iLongValue2 == GuildVerificationLevel.LOW.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_verification_level_change_low;
                }
                if (iLongValue2 == GuildVerificationLevel.MEDIUM.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_verification_level_change_medium;
                }
                if (iLongValue2 == GuildVerificationLevel.HIGH.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_verification_level_change_high;
                }
                if (iLongValue2 == GuildVerificationLevel.HIGHEST.getApiValue()) {
                    return R.string.guild_settings_audit_log_guild_verification_level_change_very_high;
                }
                return 0;
            case -154917112:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_AFK_TIMEOUT)) {
                    return R.string.guild_settings_audit_log_guild_afk_timeout_change;
                }
                return 0;
            case 3373707:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                    return R.string.guild_settings_audit_log_guild_name_change;
                }
                return 0;
            case 226923479:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DISCOVERY_SPLASH_HASH)) {
                    return R.string.guild_settings_audit_log_guild_discovery_splash_hash_change;
                }
                return 0;
            case 643741670:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_SPLASH_HASH)) {
                    return R.string.guild_settings_audit_log_guild_splash_hash_change;
                }
                return 0;
            case 706006559:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_RULES_CHANNEL_ID)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_guild_rules_channel_id_clear, R.string.guild_settings_audit_log_guild_rules_channel_id_change);
                }
                return 0;
            case 945133165:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_MFA_LEVEL)) {
                    return 0;
                }
                Object value4 = change.getValue();
                Objects.requireNonNull(value4, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue3 = (int) ((Long) value4).longValue();
                if (iLongValue3 == 0) {
                    return R.string.guild_settings_audit_log_guild_mfa_level_disabled;
                }
                if (iLongValue3 != 1) {
                    return 0;
                }
                return R.string.guild_settings_audit_log_guild_mfa_level_enabled;
            case 950953474:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_UPDATES_CHANNEL_ID)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_guild_updates_channel_id_clear, R.string.guild_settings_audit_log_guild_updates_channel_id_change);
                }
                return 0;
            case 1207357234:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_DEFAULT_MESSAGE_NOTIFICATIONS)) {
                    return 0;
                }
                Object value5 = change.getValue();
                Objects.requireNonNull(value5, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue4 = (int) ((Long) value5).longValue();
                if (iLongValue4 == 0) {
                    return R.string.guild_settings_audit_log_guild_default_message_notifications_change_all_messages;
                }
                if (iLongValue4 != 1) {
                    return 0;
                }
                return R.string.guild_settings_audit_log_guild_default_message_notifications_change_only_mentions;
            case 1580684753:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_VANITY_URL_CODE)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_guild_vanity_url_code_delete, R.string.guild_settings_audit_log_guild_vanity_url_code_change);
                }
                return 0;
            case 1639242418:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_WIDGET_CHANNEL_ID)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_guild_widget_channel_id_delete, R.string.guild_settings_audit_log_guild_widget_channel_id_change);
                }
                return 0;
            case 1663147559:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_OWNER_ID)) {
                    return R.string.guild_settings_audit_log_guild_owner_id_change;
                }
                return 0;
            case 1792613336:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PREFERRED_LOCALE)) {
                    return R.string.guild_settings_audit_log_guild_preferred_locale_change;
                }
                return 0;
            case 2010777670:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_WIDGET_ENABLED)) {
                    return 0;
                }
                Object value6 = change.getValue();
                Objects.requireNonNull(value6, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue2 = ((Boolean) value6).booleanValue();
                if (zBooleanValue2) {
                    return R.string.guild_settings_audit_log_guild_widget_enabled;
                }
                if (zBooleanValue2) {
                    throw new NoWhenBranchMatchedException();
                }
                return R.string.guild_settings_audit_log_guild_widget_disabled;
            default:
                return 0;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getGuildScheduledEventChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        switch (key.hashCode()) {
            case -1930808873:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_scheduled_event_channel_clear, R.string.guild_settings_audit_log_scheduled_event_channel);
                }
                return 0;
            case -1724546052:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION)) {
                    return R.string.guild_settings_audit_log_scheduled_event_description_create;
                }
                return 0;
            case -1443139214:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_IMAGE_HASH)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_scheduled_event_image_hash_remove, R.string.guild_settings_audit_log_scheduled_event_image_hash_change);
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
                    return R.string.guild_settings_audit_log_scheduled_event_status_scheduled;
                }
                if (iLongValue == GuildScheduledEventStatus.ACTIVE.getApiValue()) {
                    return R.string.guild_settings_audit_log_scheduled_event_status_active;
                }
                if (iLongValue == GuildScheduledEventStatus.COMPLETED.getApiValue()) {
                    return R.string.guild_settings_audit_log_scheduled_event_status_completed;
                }
                if (iLongValue == GuildScheduledEventStatus.CANCELED.getApiValue()) {
                    return R.string.guild_settings_audit_log_scheduled_event_status_canceled;
                }
                return 0;
            case 3373707:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                    return R.string.guild_settings_audit_log_scheduled_event_name_create;
                }
                return 0;
            case 1281710614:
                if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_ENTITY_TYPE)) {
                    return 0;
                }
                Object value2 = change.getValue();
                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue2 = (int) ((Long) value2).longValue();
                if (iLongValue2 == GuildScheduledEventEntityType.NONE.getApiValue()) {
                    return R.string.guild_settings_audit_log_scheduled_event_entity_type_none;
                }
                if (iLongValue2 == GuildScheduledEventEntityType.STAGE_INSTANCE.getApiValue()) {
                    return R.string.guild_settings_audit_log_scheduled_event_entity_type_stage_instance;
                }
                if (iLongValue2 == GuildScheduledEventEntityType.VOICE.getApiValue()) {
                    return R.string.guild_settings_audit_log_scheduled_event_entity_type_voice;
                }
                if (iLongValue2 == GuildScheduledEventEntityType.EXTERNAL.getApiValue()) {
                    return R.string.guild_settings_audit_log_scheduled_event_entity_type_external;
                }
                return 0;
            case 1901043637:
                if (key.equals(ModelAuditLogEntry.CHANGE_KEY_LOCATION)) {
                    return getNullableNewValueString(change, R.string.guild_settings_audit_log_scheduled_event_location_clear, R.string.guild_settings_audit_log_scheduled_event_location);
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
                    return R.string.guild_settings_audit_log_stage_instance_privacy_level_guild_only;
                }
                if (iLongValue3 == StageInstancePrivacyLevel.PUBLIC.getApiValue()) {
                    return R.string.guild_settings_audit_log_stage_instance_privacy_level_public;
                }
                return 0;
            default:
                return 0;
        }
    }

    @StringRes
    private final int getIntegrationChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        int iHashCode = key.hashCode();
        if (iHashCode == -1743820047) {
            if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_ENABLE_EMOTICONS)) {
                return 0;
            }
            Object value = change.getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) value).booleanValue();
            if (zBooleanValue) {
                return R.string.guild_settings_audit_log_integration_enable_emoticons_on;
            }
            if (zBooleanValue) {
                throw new NoWhenBranchMatchedException();
            }
            return R.string.guild_settings_audit_log_integration_enable_emoticons_off;
        }
        if (iHashCode != -486786702) {
            if (iHashCode == 1767574344 && key.equals(ModelAuditLogEntry.CHANGE_KEY_EXPIRE_GRACE_PERIOD)) {
                return R.string.guild_settings_audit_log_integration_expire_grace_period;
            }
            return 0;
        }
        if (!key.equals(ModelAuditLogEntry.CHANGE_KEY_EXPIRE_BEHAVIOR)) {
            return 0;
        }
        Object value2 = change.getValue();
        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
        int iLongValue = (int) ((Long) value2).longValue();
        if (iLongValue == 0) {
            return R.string.guild_settings_audit_log_integration_expire_behavior_remove_synced_role;
        }
        if (iLongValue != 1) {
            return 0;
        }
        return R.string.guild_settings_audit_log_integration_expire_behavior_kick_from_server;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getInviteChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1930808873:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                        return R.string.guild_settings_audit_log_invite_channel_create;
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return R.string.guild_settings_audit_log_common_reason;
                    }
                    break;
                case 3059181:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                        return R.string.guild_settings_audit_log_invite_code_create;
                    }
                    break;
                case 408141255:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MAX_USES)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                        return ((int) ((Long) value).longValue()) != 0 ? R.string.guild_settings_audit_log_invite_max_uses_create : R.string.guild_settings_audit_log_invite_max_uses_create_infinite;
                    }
                    break;
                case 844430244:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MAX_AGE)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                        return ((int) ((Long) value2).longValue()) != 0 ? R.string.guild_settings_audit_log_invite_max_age_create : R.string.guild_settings_audit_log_invite_max_age_create_infinite;
                    }
                    break;
                case 1984986705:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_TEMPORARY)) {
                        Object value3 = change.getValue();
                        Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value3).booleanValue();
                        if (zBooleanValue) {
                            return R.string.guild_settings_audit_log_invite_temporary_on;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.guild_settings_audit_log_invite_temporary_off;
                    }
                    break;
            }
        }
        return 0;
    }

    private final int getNullableNewOrOldValueString(ModelAuditLogEntry.Change change, @StringRes Integer num, @StringRes Integer num2, @StringRes Integer num3, @StringRes Integer num4) {
        if (change.getNewValue() == null || change.getOldValue() == null) {
            if (change.getNewValue() != null) {
                num = num2;
            } else {
                num = change.getOldValue() != null ? num3 : num4;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static /* synthetic */ int getNullableNewOrOldValueString$default(AuditLogChangeUtils auditLogChangeUtils, ModelAuditLogEntry.Change change, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        return auditLogChangeUtils.getNullableNewOrOldValueString(change, (i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    private final int getNullableNewValueString(ModelAuditLogEntry.Change change, @StringRes int i, @StringRes int i2) {
        return change.getNewValue() == null ? i : i2;
    }

    private final int getNullableOldValueString(ModelAuditLogEntry.Change change, @StringRes int i, @StringRes int i2) {
        return change.getOldValue() == null ? i : i2;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    private final String getOverridesPluralString(Context context, ModelAuditLogEntry.Change change, ModelAuditLogEntry entry, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        CharSequence roleName;
        Object value = change.getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.Collection<*>");
        Collection collection = (Collection) value;
        ModelAuditLogEntry.Options options = entry.getOptions();
        Integer numValueOf = options != null ? Integer.valueOf(options.getType()) : null;
        Object objB = "";
        if (numValueOf != null && numValueOf.intValue() == 1) {
            Map<Long, ? extends CharSequence> map = targets.get(ModelAuditLogEntry.TargetType.USER);
            if (map != null) {
                ModelAuditLogEntry.Options options2 = entry.getOptions();
                roleName = map.get(options2 != null ? Long.valueOf(options2.getId()) : null);
            } else {
                roleName = null;
            }
        } else if (numValueOf != null && numValueOf.intValue() == 0) {
            ModelAuditLogEntry.Options options3 = entry.getOptions();
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
                        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                        objB = FormatUtils.b(context, R.string.guild_settings_audit_log_channel_permission_overrides_reset, new Object[]{StringResourceUtils.getQuantityString(resources, context, R.plurals.guild_settings_audit_log_channel_permission_overrides_reset_count, collection.size(), Integer.valueOf(collection.size())), roleName}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                    }
                } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                    Resources resources2 = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources2, "context.resources");
                    objB = FormatUtils.b(context, R.string.guild_settings_audit_log_channel_permission_overrides_granted, new Object[]{StringResourceUtils.getQuantityString(resources2, context, R.plurals.guild_settings_audit_log_channel_permission_overrides_granted_count, collection.size(), Integer.valueOf(collection.size())), roleName}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                }
            } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                Resources resources3 = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources3, "context.resources");
                objB = FormatUtils.b(context, R.string.guild_settings_audit_log_channel_permission_overrides_denied, new Object[]{StringResourceUtils.getQuantityString(resources3, context, R.plurals.guild_settings_audit_log_channel_permission_overrides_denied_count, collection.size(), Integer.valueOf(collection.size())), roleName}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
        }
        return objB.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final CharSequence getPluralString(Context context, ModelAuditLogEntry.Change change) {
        Object value = change.getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.Collection<*>");
        Collection collection = (Collection) value;
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case 1168893:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_ADD)) {
                        Resources resources = context.getResources();
                        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                        return StringResourceUtils.getQuantityString(resources, context, R.plurals.guild_settings_audit_log_member_roles_add_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
                case 3079692:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                        Resources resources2 = context.getResources();
                        Intrinsics3.checkNotNullExpressionValue(resources2, "context.resources");
                        return StringResourceUtils.getQuantityString(resources2, context, R.plurals.guild_settings_audit_log_channel_permission_overrides_denied_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
                case 92906313:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                        Resources resources3 = context.getResources();
                        Intrinsics3.checkNotNullExpressionValue(resources3, "context.resources");
                        return StringResourceUtils.getQuantityString(resources3, context, R.plurals.guild_settings_audit_log_channel_permission_overrides_granted_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
                case 950750632:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_REMOVE)) {
                        Resources resources4 = context.getResources();
                        Intrinsics3.checkNotNullExpressionValue(resources4, "context.resources");
                        return StringResourceUtils.getQuantityString(resources4, context, R.plurals.guild_settings_audit_log_member_roles_remove_count, collection.size(), Integer.valueOf(collection.size()));
                    }
                    break;
            }
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getRoleChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1390796524:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ICON_HASH)) {
                        return R.string.guild_settings_audit_log_role_icon_hash_change;
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return R.string.guild_settings_audit_log_common_reason;
                    }
                    break;
                case 3079692:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                        return R.string.guild_settings_audit_log_role_permissions_denied;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_role_name_create, R.string.guild_settings_audit_log_role_name_change);
                    }
                    break;
                case 64859716:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MENTIONABLE)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (zBooleanValue) {
                            return R.string.guild_settings_audit_log_role_mentionable_on;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.guild_settings_audit_log_role_mentionable_off;
                    }
                    break;
                case 92906313:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                        return R.string.guild_settings_audit_log_role_permissions_granted;
                    }
                    break;
                case 94842723:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_COLOR)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                        return ((Long) value2).longValue() == 0 ? R.string.guild_settings_audit_log_role_color_none : R.string.guild_settings_audit_log_role_color;
                    }
                    break;
                case 99457571:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_HOIST)) {
                        Object value3 = change.getValue();
                        Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) value3).booleanValue();
                        if (zBooleanValue2) {
                            return R.string.guild_settings_audit_log_role_hoist_on;
                        }
                        if (zBooleanValue2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.guild_settings_audit_log_role_hoist_off;
                    }
                    break;
                case 1052836964:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_UNICODE_EMOJI)) {
                        return R.string.guild_settings_audit_log_role_unicode_emoji_change;
                    }
                    break;
            }
        }
        return 0;
    }

    @StringRes
    private final int getStageInstanceChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key == null) {
            return 0;
        }
        int iHashCode = key.hashCode();
        if (iHashCode == 110546223) {
            if (key.equals(ModelAuditLogEntry.CHANGE_KEY_TOPIC)) {
                return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_topic_create, R.string.guild_settings_audit_log_channel_topic_change);
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
            return R.string.guild_settings_audit_log_stage_instance_privacy_level_guild_only;
        }
        if (iLongValue == StageInstancePrivacyLevel.PUBLIC.getApiValue()) {
            return R.string.guild_settings_audit_log_stage_instance_privacy_level_public;
        }
        return 0;
    }

    @StringRes
    private final int getStickerChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            int iHashCode = key.hashCode();
            if (iHashCode != -1724546052) {
                if (iHashCode != 3373707) {
                    if (iHashCode == 3552281 && key.equals(ModelAuditLogEntry.CHANGE_KEY_TAGS)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_tags_create, R.string.guild_settings_audit_log_tags_change);
                    }
                } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                    return getNullableOldValueString(change, R.string.guild_settings_audit_log_name_create, R.string.guild_settings_audit_log_name_change);
                }
            } else if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION)) {
                return getNullableOldValueString(change, R.string.guild_settings_audit_log_description_create, R.string.guild_settings_audit_log_description_change);
            }
        }
        return 0;
    }

    @StringRes
    private final int getStringForPermission(long permission, ModelAuditLogEntry log) {
        if (permission == 1) {
            return R.string.create_instant_invite;
        }
        if (permission == 2) {
            return R.string.kick_members;
        }
        if (permission == 4) {
            return R.string.ban_members;
        }
        if (permission == 8) {
            return R.string.administrator;
        }
        if (permission == 16) {
            return (log.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL || log.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE) ? R.string.manage_channel : R.string.manage_channels;
        }
        if (permission == 32) {
            return R.string.manage_server;
        }
        if (permission == Permission.VIEW_GUILD_ANALYTICS) {
            return R.string.view_guild_analytics;
        }
        if (permission == Permission.CHANGE_NICKNAME) {
            return R.string.change_nickname;
        }
        if (permission == Permission.MANAGE_NICKNAMES) {
            return R.string.manage_nicknames;
        }
        if (permission == Permission.MANAGE_ROLES) {
            return R.string.manage_roles;
        }
        if (permission == Permission.MANAGE_WEBHOOKS) {
            return R.string.manage_webhooks;
        }
        if (permission == Permission.MANAGE_EMOJIS_AND_STICKERS) {
            return R.string.manage_emojis_and_stickers;
        }
        if (permission == Permission.MANAGE_EVENTS) {
            return R.string.manage_events;
        }
        if (permission == 128) {
            return R.string.view_audit_log;
        }
        if (permission == Permission.VIEW_CHANNEL) {
            return R.string.read_messages;
        }
        if (permission == Permission.SEND_MESSAGES) {
            return R.string.send_messages;
        }
        if (permission == Permission.SEND_TTS_MESSAGES) {
            return R.string.send_tts_messages;
        }
        if (permission == Permission.MANAGE_MESSAGES) {
            return R.string.manage_messages;
        }
        if (permission == Permission.EMBED_LINKS) {
            return R.string.embed_links;
        }
        if (permission == Permission.ATTACH_FILES) {
            return R.string.attach_files;
        }
        if (permission == Permission.READ_MESSAGE_HISTORY) {
            return R.string.read_message_history;
        }
        if (permission == Permission.MENTION_EVERYONE) {
            return R.string.mention_everyone_android;
        }
        if (permission == Permission.USE_EXTERNAL_EMOJIS) {
            return R.string.use_external_emojis;
        }
        if (permission == Permission.USE_EXTERNAL_STICKERS) {
            return R.string.role_permissions_use_external_stickers;
        }
        if (permission == 64) {
            return R.string.add_reactions;
        }
        if (permission == Permission.CONNECT) {
            return R.string.connect;
        }
        if (permission == Permission.SPEAK) {
            return R.string.speak;
        }
        if (permission == Permission.MUTE_MEMBERS) {
            return R.string.mute_members;
        }
        if (permission == Permission.DEAFEN_MEMBERS) {
            return R.string.deafen_members;
        }
        if (permission == Permission.MOVE_MEMBERS) {
            return R.string.move_members;
        }
        if (permission == Permission.USE_VAD) {
            return R.string.use_vad;
        }
        if (permission == 256) {
            return R.string.priority_speaker;
        }
        if (permission == 512) {
            return R.string.video;
        }
        if (permission == Permission.USE_APPLICATION_COMMANDS) {
            return R.string.use_application_commands;
        }
        if (permission == Permission.REQUEST_TO_SPEAK) {
            return R.string.request_to_speak;
        }
        if (permission == Permission.SEND_MESSAGES_IN_THREADS) {
            return R.string.send_messages_in_threads;
        }
        if (permission == Permission.CREATE_PUBLIC_THREADS) {
            return R.string.create_public_threads;
        }
        if (permission == Permission.CREATE_PRIVATE_THREADS) {
            return R.string.create_private_threads;
        }
        if (permission == Permission.MANAGE_THREADS) {
            return R.string.manage_threads;
        }
        if (permission == Permission.MODERATE_MEMBERS) {
            return R.string.moderate_member;
        }
        return 0;
    }

    private final CharSequence getStringForVideoQualityMode(MediaSinkWantsManager.VideoQualityMode mode, Context context) {
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            return FormatUtils.b(context, R.string.video_quality_mode_auto, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (iOrdinal == 1) {
            return FormatUtils.b(context, R.string.video_quality_mode_full, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getTextColor(Context context, ModelAuditLogEntry auditLogEntry) {
        ModelAuditLogEntry.ActionType actionType = auditLogEntry.getActionType();
        if (actionType != null) {
            int iOrdinal = actionType.ordinal();
            if (iOrdinal == 1) {
                return ColorCompat.getColor(context, R.color.status_green_500);
            }
            if (iOrdinal == 2) {
                return ColorCompat.getColor(context, R.color.status_yellow_400);
            }
            if (iOrdinal == 3) {
                return ColorCompat.getColor(context, R.color.status_red_400);
            }
        }
        return ColorCompat.getColor(context, R.color.primary_300);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getThreadChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1716307998:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ARCHIVED)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (zBooleanValue) {
                            return R.string.guild_settings_audit_log_thread_archived;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.guild_settings_audit_log_thread_unarchived;
                    }
                    break;
                case -1097452790:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_LOCKED)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) value2).booleanValue();
                        if (zBooleanValue2) {
                            return R.string.guild_settings_audit_log_thread_locked;
                        }
                        if (zBooleanValue2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.guild_settings_audit_log_thread_unlocked;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_thread_name_create, R.string.guild_settings_audit_log_thread_name_change);
                    }
                    break;
                case 987155184:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_RATE_LIMIT_PER_USER)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_channel_rate_limit_per_user_create, R.string.guild_settings_audit_log_channel_rate_limit_per_user_change);
                    }
                    break;
                case 1901007105:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_thread_auto_archive_duration_create, R.string.guild_settings_audit_log_thread_auto_archive_duration_change);
                    }
                    break;
            }
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getUserChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1919744682:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PRUNE_DELETE_DAYS)) {
                        return R.string.guild_settings_audit_log_member_prune_delete_days;
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return R.string.guild_settings_audit_log_common_reason;
                    }
                    break;
                case 1168893:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_ADD)) {
                        return R.string.guild_settings_audit_log_member_roles_add;
                    }
                    break;
                case 3079270:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DEAF)) {
                        Object value = change.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        if (zBooleanValue) {
                            return R.string.guild_settings_audit_log_member_deaf_on;
                        }
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.guild_settings_audit_log_member_deaf_off;
                    }
                    break;
                case 3363353:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_MUTE)) {
                        Object value2 = change.getValue();
                        Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) value2).booleanValue();
                        if (zBooleanValue2) {
                            return R.string.guild_settings_audit_log_member_mute_on;
                        }
                        if (zBooleanValue2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.guild_settings_audit_log_member_mute_off;
                    }
                    break;
                case 3381091:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NICK)) {
                        return getNullableNewOrOldValueString$default(this, change, Integer.valueOf(R.string.guild_settings_audit_log_member_nick_change), Integer.valueOf(R.string.guild_settings_audit_log_member_nick_create), Integer.valueOf(R.string.guild_settings_audit_log_member_nick_delete), null, 8, null);
                    }
                    break;
                case 950750632:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_ROLES_REMOVE)) {
                        return R.string.guild_settings_audit_log_member_roles_remove;
                    }
                    break;
                case 1217496932:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_COMMUNICATION_DISABLED)) {
                        return getNullableNewValueString(change, R.string.guild_settings_audit_log_communication_disabled_until_removed, R.string.guild_settings_audit_log_communication_disabled_until);
                    }
                    break;
            }
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @StringRes
    private final int getWebhookChangeString(ModelAuditLogEntry.Change change) {
        String key = change.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1930808873:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_webhook_channel_create, R.string.guild_settings_audit_log_webhook_channel_change);
                    }
                    break;
                case -934964668:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                        return R.string.guild_settings_audit_log_common_reason;
                    }
                    break;
                case 3373707:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        return getNullableOldValueString(change, R.string.guild_settings_audit_log_webhook_name_create, R.string.guild_settings_audit_log_webhook_name_change);
                    }
                    break;
                case 396929076:
                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_AVATAR_HASH)) {
                        return R.string.guild_settings_audit_log_webhook_avatar;
                    }
                    break;
            }
        }
        return 0;
    }

    private final boolean hasNewValue(ModelAuditLogEntry.Change change, String str) {
        return change.getNewValue() != null && Intrinsics3.areEqual(change.getKey(), str);
    }

    private final String renderPermissionList(ModelAuditLogEntry.Change change, ModelAuditLogEntry auditLogEntry, Context context) {
        Object value = change.getValue();
        if (!(value instanceof Set)) {
            value = null;
        }
        Set set = (Set) value;
        return set != null ? _Sequences2.joinToString$default(_Sequences2.filterNot(_Sequences2.map(_Sequences2.filter(_Sequences2.mapNotNull(_Sequences2.sorted(_Collections.asSequence(set)), new AnonymousClass1(auditLogEntry)), AnonymousClass2.INSTANCE), new AnonymousClass3(context)), AnonymousClass4.INSTANCE), null, null, null, 0, null, null, 63, null) : "";
    }

    private final String renderPermissions(ModelAuditLogEntry.Change change, ModelAuditLogEntry auditLogEntry, Context context, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        return getOverridesPluralString(context, change, auditLogEntry, targets) + "\n" + renderPermissionList(change, auditLogEntry, context);
    }

    private final String renderRoles(Context context, ModelAuditLogEntry.Change change) {
        String string = getPluralString(context, change).toString() + "\n";
        Object newValue = change.getNewValue();
        Objects.requireNonNull(newValue, "null cannot be cast to non-null type kotlin.collections.List<com.discord.models.domain.ModelAuditLogEntry.ChangeNameId>");
        boolean z2 = false;
        for (ModelAuditLogEntry.ChangeNameId changeNameId : (List) newValue) {
            if (z2) {
                string = outline.w(string, ", ");
            } else {
                z2 = true;
            }
            StringBuilder sbU = outline.U(string);
            sbU.append(changeNameId.getName());
            string = sbU.toString();
        }
        return string;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final boolean shouldNotRenderChange(ModelAuditLogEntry auditLogEntry, ModelAuditLogEntry.Change change) {
        String key;
        if (auditLogEntry.getActionType() != ModelAuditLogEntry.ActionType.DELETE || RENDERABLE_DELETE_ACTION_TYPES.contains(Integer.valueOf(auditLogEntry.getActionTypeId()))) {
            if (auditLogEntry.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL) {
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
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE) {
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
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry.TargetType.INVITE) {
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
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry.TargetType.WEBHOOK) {
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
            } else if (auditLogEntry.getTargetType() == ModelAuditLogEntry.TargetType.INTEGRATION) {
                String key6 = change.getKey();
                if (key6 == null || key6.hashCode() != 3575610 || !key6.equals("type")) {
                    return false;
                }
            } else {
                if (auditLogEntry.getTargetType() != ModelAuditLogEntry.TargetType.STICKER || (key = change.getKey()) == null) {
                    return false;
                }
                switch (key.hashCode()) {
                    case -1724546052:
                        if (key.equals(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION)) {
                            return StringsJVM.isBlank(change.getValue().toString());
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
    public final CharSequence getChangeSummary(Context context, ModelAuditLogEntry auditLogEntry, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, ? extends CharSequence>> targets) {
        int i;
        int iOrdinal;
        int guildChangeString;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(auditLogEntry, "auditLogEntry");
        Intrinsics3.checkNotNullParameter(targets, "targets");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Typeface typefaceCreate = Typeface.create(FontUtils.INSTANCE.getThemedFont(context, R.attr.font_monospace), 0);
        List<ModelAuditLogEntry.Change> changes = auditLogEntry.getChanges();
        if (changes != null) {
            int i2 = 0;
            for (ModelAuditLogEntry.Change change : changes) {
                AuditLogChangeUtils auditLogChangeUtils = INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(change, "change");
                if (!auditLogChangeUtils.shouldNotRenderChange(auditLogEntry, change)) {
                    ModelAuditLogEntry.TargetType targetType = auditLogEntry.getTargetType();
                    if (targetType != null && (iOrdinal = targetType.ordinal()) != 0) {
                        switch (iOrdinal) {
                            case 2:
                                guildChangeString = auditLogChangeUtils.getGuildChangeString(change);
                                i = guildChangeString;
                                break;
                            case 3:
                            case 4:
                                guildChangeString = auditLogChangeUtils.getChannelChangeString(change);
                                i = guildChangeString;
                                break;
                            case 5:
                                guildChangeString = auditLogChangeUtils.getUserChangeString(change);
                                i = guildChangeString;
                                break;
                            case 6:
                                guildChangeString = auditLogChangeUtils.getRoleChangeString(change);
                                i = guildChangeString;
                                break;
                            case 7:
                                guildChangeString = auditLogChangeUtils.getInviteChangeString(change);
                                i = guildChangeString;
                                break;
                            case 8:
                                guildChangeString = auditLogChangeUtils.getWebhookChangeString(change);
                                i = guildChangeString;
                                break;
                            case 9:
                                guildChangeString = auditLogChangeUtils.getEmojiChangeString(change);
                                i = guildChangeString;
                                break;
                            case 10:
                                guildChangeString = auditLogChangeUtils.getIntegrationChangeString(change);
                                i = guildChangeString;
                                break;
                            case 11:
                                guildChangeString = auditLogChangeUtils.getStageInstanceChangeString(change);
                                i = guildChangeString;
                                break;
                            case 12:
                                guildChangeString = auditLogChangeUtils.getGuildScheduledEventChangeString(change);
                                i = guildChangeString;
                                break;
                            case 13:
                                guildChangeString = auditLogChangeUtils.getStickerChangeString(change);
                                i = guildChangeString;
                                break;
                            case 14:
                                guildChangeString = auditLogChangeUtils.getThreadChangeString(change);
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
                        Intrinsics3.checkNotNullExpressionValue(typefaceCreate, "numberTypeface");
                        spannableStringBuilder.setSpan(new TypefaceSpanCompat(typefaceCreate), iMax, length, 33);
                        spannableStringBuilder.append(FormatUtils.g(auditLogChangeUtils.getChangeTextWithParams(context, auditLogEntry, change, i, targets), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null));
                        if (Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_COLOR) && change.getValue() != null) {
                            Object value = change.getValue();
                            Long l = (Long) (value instanceof Long ? value : null);
                            if (l == null || l.longValue() != 0) {
                                spannableStringBuilder.append((CharSequence) "●");
                                Object value2 = change.getValue();
                                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                                String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & ((int) ((Long) value2).longValue()))}, 1));
                                Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str)), Strings4.getLastIndex(spannableStringBuilder), Strings4.getLastIndex(spannableStringBuilder) + 1, 33);
                            }
                        }
                        i2 = i3;
                    } else {
                        AppLog appLog = AppLog.g;
                        StringBuilder sbU = outline.U("No change text for actiontype: ");
                        sbU.append(auditLogEntry.getActionTypeId());
                        sbU.append(" key:");
                        sbU.append(change.getKey());
                        Logger.w$default(appLog, "Audit Logs", sbU.toString(), null, 4, null);
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    public final boolean hasChangesToRender(ModelAuditLogEntry log) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(log, "log");
        List<ModelAuditLogEntry.Change> changes = log.getChanges();
        if (changes == null) {
            return false;
        }
        if (changes.isEmpty()) {
            z2 = false;
        } else {
            for (ModelAuditLogEntry.Change change : changes) {
                AuditLogChangeUtils auditLogChangeUtils = INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(change, "it");
                if (!auditLogChangeUtils.shouldNotRenderChange(log, change)) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public final List<ModelAuditLogEntry.Change> transformPermissionChange(ModelAuditLogEntry.Change change) {
        Intrinsics3.checkNotNullParameter(change, "change");
        Tuples2<HashSet<Long>, HashSet<Long>> tuples2CalculatePermissionChange = calculatePermissionChange(change);
        ArrayList arrayList = new ArrayList();
        if (!tuples2CalculatePermissionChange.getFirst().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry.Change(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, null, tuples2CalculatePermissionChange.getFirst()));
        }
        if (!tuples2CalculatePermissionChange.getSecond().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry.Change(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED, null, tuples2CalculatePermissionChange.getSecond()));
        }
        return arrayList;
    }

    public final List<ModelAuditLogEntry.Change> transformPermissionOverride(ModelAuditLogEntry.Change change) {
        Intrinsics3.checkNotNullParameter(change, "change");
        Tuples2<HashSet<Long>, HashSet<Long>> tuples2CalculatePermissionChange = calculatePermissionChange(change);
        ArrayList arrayList = new ArrayList();
        if (!tuples2CalculatePermissionChange.getFirst().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry.Change(change.getKey(), null, tuples2CalculatePermissionChange.getFirst()));
        }
        if (!tuples2CalculatePermissionChange.getSecond().isEmpty()) {
            arrayList.add(new ModelAuditLogEntry.Change(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, null, tuples2CalculatePermissionChange.getSecond()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.discord.utilities.auditlogs.AuditLogChangeUtils$getChangeTextWithParams$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuditLogChangeUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ ModelAuditLogEntry.Change $change;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelAuditLogEntry.Change change) {
            super(1);
            this.$change = change;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            String string;
            String string2;
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            Object oldValue = this.$change.getOldValue();
            String str = "";
            if (oldValue == null || (string = oldValue.toString()) == null) {
                string = "";
            }
            map.put("oldValue", string);
            Map<String, String> map2 = renderContext.args;
            Object newValue = this.$change.getNewValue();
            if (newValue != null && (string2 = newValue.toString()) != null) {
                str = string2;
            }
            map2.put("newValue", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
