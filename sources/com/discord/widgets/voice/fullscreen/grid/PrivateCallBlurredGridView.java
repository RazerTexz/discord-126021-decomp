package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.GridLayout;
import android.widget.GridLayout$LayoutParams;
import androidx.core.graphics.ColorUtils;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.mmin18.widget.RealtimeBlurView;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PrivateCallBlurredGridView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallBlurredGridView extends FrameLayout {
    private final RealtimeBlurView blurView;
    private List<StoreVoiceParticipants$VoiceUser> callUsers;
    private final GridLayout gridView;
    private final LinkedHashMap<Long, SimpleDraweeView> gridViewItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallBlurredGridView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        this.callUsers = n.emptyList();
        RealtimeBlurView realtimeBlurView = new RealtimeBlurView(getContext(), null);
        this.blurView = realtimeBlurView;
        GridLayout gridLayout = new GridLayout(getContext());
        this.gridView = gridLayout;
        this.gridViewItems = new LinkedHashMap<>();
        gridLayout.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        gridLayout.setColumnCount(getColumnSize());
        int alphaComponent = ColorUtils.setAlphaComponent(ColorCompat.getColor(getContext(), 2131100219), (int) 204.0d);
        realtimeBlurView.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        realtimeBlurView.setBlurRadius(DimenUtils.dpToPixels(64));
        realtimeBlurView.setOverlayColor(alphaComponent);
        addView(gridLayout);
        addView(realtimeBlurView);
    }

    private final SimpleDraweeView createGridViewItem(boolean isFullWidth) {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
        simpleDraweeView.setLayoutParams(new GridLayout$LayoutParams(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, isFullWidth ? getColumnSize() : 1, 1.0f)));
        return simpleDraweeView;
    }

    private final int getColumnSize() {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 3 : 2;
    }

    private final int getMaxShownParticipants() {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 6 : 4;
    }

    private final boolean isLandscape(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }

    public final void configure(List<StoreVoiceParticipants$VoiceUser> callUsers) {
        m.checkNotNullParameter(callUsers, "callUsers");
        List listTake = u.take(callUsers, getMaxShownParticipants());
        boolean z2 = listTake.size() == 2;
        boolean z3 = !CollectionExtensionsKt.equals(this.callUsers, callUsers, PrivateCallBlurredGridView$configure$callUserOrderChanged$1.INSTANCE);
        if (z3) {
            this.gridView.removeAllViews();
        }
        int i = 0;
        for (Object obj : listTake) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = (StoreVoiceParticipants$VoiceUser) obj;
            boolean z4 = (i == listTake.size() - 1) && (i + (-1)) % 2 != 0;
            LinkedHashMap<Long, SimpleDraweeView> linkedHashMap = this.gridViewItems;
            Long lValueOf = Long.valueOf(storeVoiceParticipants$VoiceUser.getUser().getId());
            SimpleDraweeView simpleDraweeViewCreateGridViewItem = linkedHashMap.get(lValueOf);
            if (simpleDraweeViewCreateGridViewItem == null) {
                simpleDraweeViewCreateGridViewItem = createGridViewItem(z4 || z2);
                linkedHashMap.put(lValueOf, simpleDraweeViewCreateGridViewItem);
            }
            SimpleDraweeView simpleDraweeView = simpleDraweeViewCreateGridViewItem;
            IconUtils.setIcon$default(simpleDraweeView, storeVoiceParticipants$VoiceUser.getUser(), 0, null, null, null, 60, null);
            if (z3) {
                this.gridView.addView(simpleDraweeView);
            }
            i = i2;
        }
        this.callUsers = callUsers;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallBlurredGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.callUsers = n.emptyList();
        RealtimeBlurView realtimeBlurView = new RealtimeBlurView(getContext(), null);
        this.blurView = realtimeBlurView;
        GridLayout gridLayout = new GridLayout(getContext());
        this.gridView = gridLayout;
        this.gridViewItems = new LinkedHashMap<>();
        gridLayout.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        gridLayout.setColumnCount(getColumnSize());
        int alphaComponent = ColorUtils.setAlphaComponent(ColorCompat.getColor(getContext(), 2131100219), (int) 204.0d);
        realtimeBlurView.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        realtimeBlurView.setBlurRadius(DimenUtils.dpToPixels(64));
        realtimeBlurView.setOverlayColor(alphaComponent);
        addView(gridLayout);
        addView(realtimeBlurView);
    }

    public /* synthetic */ PrivateCallBlurredGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
