package com.discord.widgets.notice;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetNoticeNuxOverlayBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.WidgetSettingsVoice;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetNoticeNuxOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeNuxOverlayBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NOTICE_NAME = "NUX/Overlay";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue() {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetNoticeNuxOverlay.NOTICE_NAME, null, 0L, 0, true, null, 0L, false, 0L, WidgetNoticeNuxOverlay$Companion$enqueue$notice$1.INSTANCE, 486, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetNoticeNuxOverlay() {
        super(C5419R.layout.widget_notice_nux_overlay);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoticeNuxOverlay$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeNuxOverlayBinding getBinding() {
        return (WidgetNoticeNuxOverlayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.INSTANCE.getNotices().markDialogSeen(NOTICE_NAME);
        getBinding().f17304c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeNuxOverlay.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsVoice.INSTANCE.launch(C1643a.m885x(view2, "it", "it.context"), Integer.valueOf(C5419R.id.settings_voice_overlay_toggle), true);
                WidgetNoticeNuxOverlay.this.dismiss();
            }
        });
        getBinding().f17303b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeNuxOverlay.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StoreStream.INSTANCE.getUserSettings().setIsMobileOverlayEnabled(false);
                WidgetNoticeNuxOverlay.this.dismiss();
            }
        });
    }
}
