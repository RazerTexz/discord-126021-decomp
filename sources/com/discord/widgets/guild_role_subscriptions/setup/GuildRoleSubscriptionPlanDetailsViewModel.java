package com.discord.widgets.guild_role_subscriptions.setup;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanDetailsViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: compiled from: GuildRoleSubscriptionPlanDetailsViewModel.kt */
    public static final /* data */ class ViewState {
        private final Long applicationId;
        private final String coverImage;
        private final Long coverImageAssetId;
        private final String description;
        private final boolean isFullServerGate;

        public ViewState() {
            this(null, null, null, null, false, 31, null);
        }

        public ViewState(String str, Long l, Long l2, String str2, boolean z2) {
            this.coverImage = str;
            this.applicationId = l;
            this.coverImageAssetId = l2;
            this.description = str2;
            this.isFullServerGate = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, Long l, Long l2, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewState.coverImage;
            }
            if ((i & 2) != 0) {
                l = viewState.applicationId;
            }
            Long l3 = l;
            if ((i & 4) != 0) {
                l2 = viewState.coverImageAssetId;
            }
            Long l4 = l2;
            if ((i & 8) != 0) {
                str2 = viewState.description;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                z2 = viewState.isFullServerGate;
            }
            return viewState.copy(str, l3, l4, str3, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getCoverImageAssetId() {
            return this.coverImageAssetId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsFullServerGate() {
            return this.isFullServerGate;
        }

        public final ViewState copy(String coverImage, Long applicationId, Long coverImageAssetId, String description, boolean isFullServerGate) {
            return new ViewState(coverImage, applicationId, coverImageAssetId, description, isFullServerGate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.coverImage, viewState.coverImage) && Intrinsics3.areEqual(this.applicationId, viewState.applicationId) && Intrinsics3.areEqual(this.coverImageAssetId, viewState.coverImageAssetId) && Intrinsics3.areEqual(this.description, viewState.description) && this.isFullServerGate == viewState.isFullServerGate;
        }

        public final Long getApplicationId() {
            return this.applicationId;
        }

        public final String getCoverImage() {
            return this.coverImage;
        }

        public final Long getCoverImageAssetId() {
            return this.coverImageAssetId;
        }

        public final String getDescription() {
            return this.description;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String str = this.coverImage;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Long l = this.applicationId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.coverImageAssetId;
            int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str2 = this.description;
            int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.isFullServerGate;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode4 + r1;
        }

        public final boolean isFullServerGate() {
            return this.isFullServerGate;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(coverImage=");
            sbU.append(this.coverImage);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", coverImageAssetId=");
            sbU.append(this.coverImageAssetId);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", isFullServerGate=");
            return outline.O(sbU, this.isFullServerGate, ")");
        }

        public /* synthetic */ ViewState(String str, Long l, Long l2, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) == 0 ? str2 : null, (i & 16) != 0 ? false : z2);
        }
    }

    public GuildRoleSubscriptionPlanDetailsViewModel() {
        super(new ViewState(null, null, null, null, false, 31, null));
    }

    public final void setGroupPlanDetails(GuildRoleSubscriptionGroupListing subscriptionGroupListing, Boolean fullServerGatingOverwrite) {
        Intrinsics3.checkNotNullParameter(subscriptionGroupListing, "subscriptionGroupListing");
        Long lValueOf = Long.valueOf(subscriptionGroupListing.getApplicationId());
        ImageAsset imageAsset = subscriptionGroupListing.getImageAsset();
        updateViewState(new ViewState(null, lValueOf, imageAsset != null ? Long.valueOf(imageAsset.getId()) : null, subscriptionGroupListing.getDescription(), fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : subscriptionGroupListing.getFullServerGate(), 1, null));
    }

    public final void updateCoverImage(String coverImage) {
        updateViewState(ViewState.copy$default(requireViewState(), coverImage, null, null, null, false, 30, null));
    }

    public final void updateDescription(String description) {
        updateViewState(ViewState.copy$default(requireViewState(), null, null, null, description, false, 23, null));
    }

    public final void updateFullServerGate(boolean isFullServerGate) {
        updateViewState(ViewState.copy$default(requireViewState(), null, null, null, null, isFullServerGate, 15, null));
    }
}
