package com.discord.widgets.notice;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetNoticeNuxOverlayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNoticeNuxOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeNuxOverlayBinding;", 0)};
    public static final WidgetNoticeNuxOverlay$Companion Companion = new WidgetNoticeNuxOverlay$Companion(null);
    private static final String NOTICE_NAME = "NUX/Overlay";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetNoticeNuxOverlay() {
        super(R$layout.widget_notice_nux_overlay);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoticeNuxOverlay$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeNuxOverlayBinding getBinding() {
        return (WidgetNoticeNuxOverlayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.Companion.getNotices().markDialogSeen(NOTICE_NAME);
        getBinding().c.setOnClickListener(new WidgetNoticeNuxOverlay$onViewBound$1(this));
        getBinding().f2501b.setOnClickListener(new WidgetNoticeNuxOverlay$onViewBound$2(this));
    }
}
