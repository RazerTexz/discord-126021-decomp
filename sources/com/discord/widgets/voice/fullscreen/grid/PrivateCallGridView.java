package com.discord.widgets.voice.fullscreen.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow$LayoutParams;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.discord.R$layout;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.views.VoiceUserView;
import com.google.android.material.badge.BadgeDrawable;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PrivateCallGridView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallGridView extends TableLayout {
    private static final PrivateCallGridView$Companion Companion = new PrivateCallGridView$Companion(null);

    @Deprecated
    private static final int PARTICIPANT_AVATAR_SIZE_DP = 92;

    @Deprecated
    private static final int PARTICIPANT_MARGIN = 2;

    @Deprecated
    private static final int PARTICIPANT_RING_MARGIN = 6;
    private final LinkedHashMap<Long, VoiceUserView> callUserViews;
    private List<StoreVoiceParticipants$VoiceUser> callUsers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallGridView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        this.callUsers = n.emptyList();
        this.callUserViews = new LinkedHashMap<>();
    }

    private final VoiceUserView createCallUserView() {
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        VoiceUserView voiceUserView = new VoiceUserView(context, null, 0, 6);
        TableRow$LayoutParams tableRow$LayoutParams = new TableRow$LayoutParams();
        int iDpToPixels = DimenUtils.dpToPixels(2);
        tableRow$LayoutParams.setMargins(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
        voiceUserView.setLayoutParams(tableRow$LayoutParams);
        voiceUserView.setAnimateAvatarWhenRinging(true);
        voiceUserView.setFadeWhenDisconnected(true);
        voiceUserView.setAvatarSize(DimenUtils.dpToPixels(92));
        voiceUserView.setRingMargin(DimenUtils.dpToPixels(6));
        return voiceUserView;
    }

    private final VoiceUserView getAndUpdateCallUserView(StoreVoiceParticipants$VoiceUser callUserItem) {
        LinkedHashMap<Long, VoiceUserView> linkedHashMap = this.callUserViews;
        Long lValueOf = Long.valueOf(callUserItem.getUser().getId());
        VoiceUserView voiceUserViewCreateCallUserView = linkedHashMap.get(lValueOf);
        if (voiceUserViewCreateCallUserView == null) {
            voiceUserViewCreateCallUserView = createCallUserView();
            linkedHashMap.put(lValueOf, voiceUserViewCreateCallUserView);
        }
        VoiceUserView voiceUserView = voiceUserViewCreateCallUserView;
        int i = VoiceUserView.j;
        voiceUserView.a(callUserItem, 2131165301);
        voiceUserView.setSelected(false);
        return voiceUserView;
    }

    private final int getColumnSize() {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 6 : 3;
    }

    private final int getMaxShownParticipants() {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 6 : 9;
    }

    private final View getOneOnOneSpacerView(List<StoreVoiceParticipants$VoiceUser> callUsers, int rowIndex) {
        if (!(rowIndex == 0 && callUsers.size() == 2)) {
            return null;
        }
        View viewInflate = TableLayout.inflate(getContext(), R$layout.view_private_call_grid_spacer, null);
        Objects.requireNonNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
        return (TextView) viewInflate;
    }

    @SuppressLint({"SetTextI18n"})
    private final View getOverflowParticipantView(List<StoreVoiceParticipants$VoiceUser> callUsers, int rowIndex) {
        if (!(rowIndex == ((int) Math.ceil(((double) getMaxShownParticipants()) / ((double) getColumnSize()))) - 1) || !isOverflowingParticipants(callUsers)) {
            return null;
        }
        View viewInflate = TableLayout.inflate(getContext(), R$layout.view_private_call_grid_overflow, null);
        Objects.requireNonNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewInflate;
        TableRow$LayoutParams tableRow$LayoutParams = new TableRow$LayoutParams(DimenUtils.dpToPixels(92), DimenUtils.dpToPixels(92));
        int iDpToPixels = DimenUtils.dpToPixels(2) * 4;
        tableRow$LayoutParams.setMargins(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
        textView.setLayoutParams(tableRow$LayoutParams);
        textView.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + String.valueOf(callUsers.size() - getMaxShownParticipants()));
        return textView;
    }

    private final List<StoreVoiceParticipants$VoiceUser> getVisibleCallUsers(List<StoreVoiceParticipants$VoiceUser> callUsers) {
        return isOverflowingParticipants(callUsers) ? u.take(callUsers, getMaxShownParticipants() - 1) : callUsers;
    }

    private final boolean isLandscape(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }

    private final boolean isOverflowingParticipants(List<StoreVoiceParticipants$VoiceUser> callUsers) {
        return callUsers.size() > getMaxShownParticipants();
    }

    private final void removeViewsAndSubviews() {
        for (View view : ViewGroupKt.getChildren(this)) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TableRow");
            ((TableRow) view).removeAllViews();
        }
        removeAllViews();
    }

    public final void configure(List<StoreVoiceParticipants$VoiceUser> callUsers) {
        m.checkNotNullParameter(callUsers, "callUsers");
        if (!CollectionExtensionsKt.equals(this.callUsers, callUsers, PrivateCallGridView$configure$callUserOrderChanged$1.INSTANCE)) {
            removeViewsAndSubviews();
            int i = 0;
            for (Object obj : u.chunked(getVisibleCallUsers(callUsers), getColumnSize())) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                TableRow tableRow = new TableRow(getContext());
                tableRow.setGravity(17);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    tableRow.addView(getAndUpdateCallUserView((StoreVoiceParticipants$VoiceUser) it.next()));
                }
                View overflowParticipantView = getOverflowParticipantView(callUsers, i);
                if (overflowParticipantView != null) {
                    tableRow.addView(overflowParticipantView);
                }
                View oneOnOneSpacerView = getOneOnOneSpacerView(callUsers, i);
                if (oneOnOneSpacerView != null) {
                    tableRow.addView(oneOnOneSpacerView, 1);
                }
                addView(tableRow);
                i = i2;
            }
        } else {
            Iterator<T> it2 = getVisibleCallUsers(callUsers).iterator();
            while (it2.hasNext()) {
                getAndUpdateCallUserView((StoreVoiceParticipants$VoiceUser) it2.next());
            }
        }
        this.callUsers = callUsers;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.callUsers = n.emptyList();
        this.callUserViews = new LinkedHashMap<>();
    }

    public /* synthetic */ PrivateCallGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
