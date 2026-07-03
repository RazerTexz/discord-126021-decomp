package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.core.graphics.ColorUtils;
import com.discord.C5419R;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.mmin18.widget.RealtimeBlurView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PrivateCallBlurredGridView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallBlurredGridView extends FrameLayout {
    private final RealtimeBlurView blurView;
    private List<StoreVoiceParticipants.VoiceUser> callUsers;
    private final GridLayout gridView;
    private final LinkedHashMap<Long, SimpleDraweeView> gridViewItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallBlurredGridView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        this.callUsers = C12147n.emptyList();
        RealtimeBlurView realtimeBlurView = new RealtimeBlurView(getContext(), null);
        this.blurView = realtimeBlurView;
        GridLayout gridLayout = new GridLayout(getContext());
        this.gridView = gridLayout;
        this.gridViewItems = new LinkedHashMap<>();
        gridLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        gridLayout.setColumnCount(getColumnSize());
        int alphaComponent = ColorUtils.setAlphaComponent(ColorCompat.getColor(getContext(), C5419R.color.primary_dark_600), (int) 204.0d);
        realtimeBlurView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        realtimeBlurView.setBlurRadius(DimenUtils.dpToPixels(64));
        realtimeBlurView.setOverlayColor(alphaComponent);
        addView(gridLayout);
        addView(realtimeBlurView);
    }

    private final SimpleDraweeView createGridViewItem(boolean isFullWidth) {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
        simpleDraweeView.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, isFullWidth ? getColumnSize() : 1, 1.0f)));
        return simpleDraweeView;
    }

    private final int getColumnSize() {
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 3 : 2;
    }

    private final int getMaxShownParticipants() {
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 6 : 4;
    }

    private final boolean isLandscape(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }

    public final void configure(List<StoreVoiceParticipants.VoiceUser> callUsers) {
        C12238m.checkNotNullParameter(callUsers, "callUsers");
        List listTake = C12163u.take(callUsers, getMaxShownParticipants());
        boolean z2 = listTake.size() == 2;
        boolean z3 = !CollectionExtensionsKt.equals(this.callUsers, callUsers, PrivateCallBlurredGridView$configure$callUserOrderChanged$1.INSTANCE);
        if (z3) {
            this.gridView.removeAllViews();
        }
        int i = 0;
        for (Object obj : listTake) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) obj;
            boolean z4 = (i == listTake.size() - 1) && (i + (-1)) % 2 != 0;
            LinkedHashMap<Long, SimpleDraweeView> linkedHashMap = this.gridViewItems;
            Long lValueOf = Long.valueOf(voiceUser.getUser().getId());
            SimpleDraweeView simpleDraweeViewCreateGridViewItem = linkedHashMap.get(lValueOf);
            if (simpleDraweeViewCreateGridViewItem == null) {
                simpleDraweeViewCreateGridViewItem = createGridViewItem(z4 || z2);
                linkedHashMap.put(lValueOf, simpleDraweeViewCreateGridViewItem);
            }
            SimpleDraweeView simpleDraweeView = simpleDraweeViewCreateGridViewItem;
            IconUtils.setIcon$default(simpleDraweeView, voiceUser.getUser(), 0, null, null, null, 60, null);
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
        C12238m.checkNotNullParameter(context, "context");
        this.callUsers = C12147n.emptyList();
        RealtimeBlurView realtimeBlurView = new RealtimeBlurView(getContext(), null);
        this.blurView = realtimeBlurView;
        GridLayout gridLayout = new GridLayout(getContext());
        this.gridView = gridLayout;
        this.gridViewItems = new LinkedHashMap<>();
        gridLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        gridLayout.setColumnCount(getColumnSize());
        int alphaComponent = ColorUtils.setAlphaComponent(ColorCompat.getColor(getContext(), C5419R.color.primary_dark_600), (int) 204.0d);
        realtimeBlurView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        realtimeBlurView.setBlurRadius(DimenUtils.dpToPixels(64));
        realtimeBlurView.setOverlayColor(alphaComponent);
        addView(gridLayout);
        addView(realtimeBlurView);
    }

    public /* synthetic */ PrivateCallBlurredGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
