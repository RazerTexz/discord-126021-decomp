package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.annotation.DrawableRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitViewModel extends AppViewModel<ViewState> {
    private final GuildRoleSubscriptionBenefitType benefitType;
    private final PublishSubject<Event> eventSubject;
    private final String tierName;

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
        public static final /* data */ class SendResult extends Event {
            private final Benefit benefit;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendResult(Benefit benefit) {
                super(null);
                Intrinsics3.checkNotNullParameter(benefit, "benefit");
                this.benefit = benefit;
            }

            public static /* synthetic */ SendResult copy$default(SendResult sendResult, Benefit benefit, int i, Object obj) {
                if ((i & 1) != 0) {
                    benefit = sendResult.benefit;
                }
                return sendResult.copy(benefit);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Benefit getBenefit() {
                return this.benefit;
            }

            public final SendResult copy(Benefit benefit) {
                Intrinsics3.checkNotNullParameter(benefit, "benefit");
                return new SendResult(benefit);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SendResult) && Intrinsics3.areEqual(this.benefit, ((SendResult) other).benefit);
                }
                return true;
            }

            public final Benefit getBenefit() {
                return this.benefit;
            }

            public int hashCode() {
                Benefit benefit = this.benefit;
                if (benefit != null) {
                    return benefit.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SendResult(benefit=");
                sbU.append(this.benefit);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canSubmitResult;
        private final Long channelId;
        private final String description;
        private final Emoji emoji;
        private final Integer leadingNameIconResId;
        private final String name;
        private final String tierName;

        public ViewState() {
            this(false, null, null, null, null, null, null, Opcodes.LAND, null);
        }

        public ViewState(boolean z2, String str, String str2, @DrawableRes Integer num, Emoji emoji, String str3, Long l) {
            this.canSubmitResult = z2;
            this.name = str;
            this.tierName = str2;
            this.leadingNameIconResId = num;
            this.emoji = emoji;
            this.description = str3;
            this.channelId = l;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, String str, String str2, Integer num, Emoji emoji, String str3, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.canSubmitResult;
            }
            if ((i & 2) != 0) {
                str = viewState.name;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = viewState.tierName;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                num = viewState.leadingNameIconResId;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                emoji = viewState.emoji;
            }
            Emoji emoji2 = emoji;
            if ((i & 32) != 0) {
                str3 = viewState.description;
            }
            String str6 = str3;
            if ((i & 64) != 0) {
                l = viewState.channelId;
            }
            return viewState.copy(z2, str4, str5, num2, emoji2, str6, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCanSubmitResult() {
            return this.canSubmitResult;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getLeadingNameIconResId() {
            return this.leadingNameIconResId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        public final ViewState copy(boolean canSubmitResult, String name, String tierName, @DrawableRes Integer leadingNameIconResId, Emoji emoji, String description, Long channelId) {
            return new ViewState(canSubmitResult, name, tierName, leadingNameIconResId, emoji, description, channelId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.canSubmitResult == viewState.canSubmitResult && Intrinsics3.areEqual(this.name, viewState.name) && Intrinsics3.areEqual(this.tierName, viewState.tierName) && Intrinsics3.areEqual(this.leadingNameIconResId, viewState.leadingNameIconResId) && Intrinsics3.areEqual(this.emoji, viewState.emoji) && Intrinsics3.areEqual(this.description, viewState.description) && Intrinsics3.areEqual(this.channelId, viewState.channelId);
        }

        public final boolean getCanSubmitResult() {
            return this.canSubmitResult;
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final Integer getLeadingNameIconResId() {
            return this.leadingNameIconResId;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTierName() {
            return this.tierName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        public int hashCode() {
            boolean z2 = this.canSubmitResult;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            String str = this.name;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.tierName;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.leadingNameIconResId;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            Emoji emoji = this.emoji;
            int iHashCode4 = (iHashCode3 + (emoji != null ? emoji.hashCode() : 0)) * 31;
            String str3 = this.description;
            int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Long l = this.channelId;
            return iHashCode5 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(canSubmitResult=");
            sbU.append(this.canSubmitResult);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", tierName=");
            sbU.append(this.tierName);
            sbU.append(", leadingNameIconResId=");
            sbU.append(this.leadingNameIconResId);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", channelId=");
            return outline.G(sbU, this.channelId, ")");
        }

        public /* synthetic */ ViewState(boolean z2, String str, String str2, Integer num, Emoji emoji, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : emoji, (i & 32) != 0 ? null : str3, (i & 64) == 0 ? l : null);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = GuildRoleSubscriptionBenefitType.CHANNEL;
            iArr[guildRoleSubscriptionBenefitType.ordinal()] = 1;
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType2 = GuildRoleSubscriptionBenefitType.INTANGIBLE;
            iArr[guildRoleSubscriptionBenefitType2.ordinal()] = 2;
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildRoleSubscriptionBenefitType.ordinal()] = 1;
            iArr2[guildRoleSubscriptionBenefitType2.ordinal()] = 2;
        }
    }

    public /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildRoleSubscriptionBenefitType, str, (i & 4) != 0 ? null : benefit);
    }

    public final String getTierName() {
        return this.tierName;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    public final void submitResult() {
        Benefit channelBenefit;
        Benefit benefit;
        ViewState viewStateRequireViewState = requireViewState();
        int iOrdinal = this.benefitType.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                benefit = null;
            } else {
                String name = viewStateRequireViewState.getName();
                if (name == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                Emoji emoji = viewStateRequireViewState.getEmoji();
                if (emoji == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                channelBenefit = new Benefit.IntangibleBenefit(name, emoji, viewStateRequireViewState.getDescription());
            }
            if (benefit != null) {
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new Event.SendResult(benefit));
            }
        }
        String name2 = viewStateRequireViewState.getName();
        if (name2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Emoji emoji2 = viewStateRequireViewState.getEmoji();
        if (emoji2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String description = viewStateRequireViewState.getDescription();
        Integer leadingNameIconResId = viewStateRequireViewState.getLeadingNameIconResId();
        Long channelId = viewStateRequireViewState.getChannelId();
        if (channelId == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        channelBenefit = new Benefit.ChannelBenefit(name2, emoji2, description, leadingNameIconResId, channelId.longValue());
        benefit = channelBenefit;
        if (benefit != null) {
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(new Event.SendResult(benefit));
        }
    }

    public final void updateChannel(long channelId, String channelName, Integer channelIconResId) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        updateViewState(ViewState.copy$default(requireViewState(), false, channelName, null, channelIconResId, null, null, Long.valueOf(channelId), 53, null));
    }

    public final void updateDescription(String description) {
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        updateViewState(ViewState.copy$default(requireViewState(), false, null, null, null, null, description, null, 95, null));
    }

    public final void updateEmoji(Emoji emoji) {
        updateViewState(ViewState.copy$default(requireViewState(), false, null, null, null, emoji, null, null, 111, null));
    }

    public final void updateName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        updateViewState(ViewState.copy$default(requireViewState(), false, name, null, null, null, null, null, Opcodes.LUSHR, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionTierBenefitViewModel(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "benefitType");
        boolean z2 = benefit != null;
        String name = benefit != null ? benefit.getName() : null;
        boolean z3 = benefit instanceof Benefit.ChannelBenefit;
        Benefit.ChannelBenefit channelBenefit = (Benefit.ChannelBenefit) (!z3 ? null : benefit);
        Long lValueOf = channelBenefit != null ? Long.valueOf(channelBenefit.getChannelId()) : null;
        Benefit.ChannelBenefit channelBenefit2 = (Benefit.ChannelBenefit) (!z3 ? null : benefit);
        super(new ViewState(z2, name, str, channelBenefit2 != null ? channelBenefit2.getChannelIconResId() : null, benefit != null ? benefit.getEmoji() : null, benefit != null ? benefit.getDescription() : null, lValueOf));
        this.benefitType = guildRoleSubscriptionBenefitType;
        this.tierName = str;
        this.eventSubject = PublishSubject.k0();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d  */
    @Override // b.a.d.AppViewModel
    public void updateViewState(ViewState viewState) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        int iOrdinal = this.benefitType.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                String name = viewState.getName();
                if (!(name == null || StringsJVM.isBlank(name)) && viewState.getEmoji() != null) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            String name2 = viewState.getName();
            if ((name2 == null || StringsJVM.isBlank(name2)) || viewState.getEmoji() == null || viewState.getChannelId() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        super.updateViewState(ViewState.copy$default(viewState, z2, null, null, null, null, null, null, 126, null));
    }
}
