package com.discord.widgets.media;

import android.net.Uri;
import android.view.View;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetQrScannerBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.auth.WidgetRemoteAuth;
import com.google.android.material.chip.Chip;
import com.google.zxing.Result;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.dm7.barcodescanner.zxing.ZXingScannerView$b;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQRScanner extends AppFragment implements ZXingScannerView$b {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetQRScanner.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQrScannerBinding;", 0)};
    public static final WidgetQRScanner$Companion Companion = new WidgetQRScanner$Companion(null);
    private static final String EXTRA_SHOW_HELP_CHIP = "SHOW_HELP_CHIP";
    private static final int MAIN_BACK_CAMERA = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetQRScanner() {
        super(R$layout.widget_qr_scanner);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetQRScanner$binding$2.INSTANCE, new WidgetQRScanner$binding$3(this));
    }

    public static final /* synthetic */ WidgetQrScannerBinding access$getBinding$p(WidgetQRScanner widgetQRScanner) {
        return widgetQRScanner.getBinding();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetQRScanner widgetQRScanner, WidgetQrScannerBinding widgetQrScannerBinding) {
        widgetQRScanner.onViewBindingDestroy(widgetQrScannerBinding);
    }

    private final WidgetQrScannerBinding getBinding() {
        return (WidgetQrScannerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetQrScannerBinding binding) {
        binding.f2515b.a();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    /* JADX WARN: Code duplicated, block: B:17:0x0058  */
    /* JADX WARN: Code duplicated, block: B:18:0x0068  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView$b
    public void handleResult(Result rawResult) {
        String str;
        IntentUtils intentUtils;
        String path;
        MatchResult matchResultMatchEntire;
        if (rawResult == null || (str = rawResult.a) == null) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (URLUtil.isValidUrl(str)) {
            b.a.d.m0.a aVar = b.a.d.m0.a.G;
            m.checkNotNullExpressionValue(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
            if (aVar.a(uri.getHost())) {
                path = uri.getPath();
                if (path != null) {
                    b.a.d.m0.a aVar2 = b.a.d.m0.a.G;
                    Regex regex = b.a.d.m0.a.D;
                    m.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = regex.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    WidgetRemoteAuth.Companion.launch(requireContext(), (String) u.last((List) matchResultMatchEntire.getGroupValues()));
                } else {
                    UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                }
            } else {
                intentUtils = IntentUtils.INSTANCE;
                m.checkNotNullExpressionValue(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
                if (intentUtils.isDiscordAppUri(uri)) {
                    path = uri.getPath();
                    if (path != null) {
                        b.a.d.m0.a aVar3 = b.a.d.m0.a.G;
                        Regex regex2 = b.a.d.m0.a.D;
                        m.checkNotNullExpressionValue(path, "it");
                        matchResultMatchEntire = regex2.matchEntire(path);
                    } else {
                        matchResultMatchEntire = null;
                    }
                    if (matchResultMatchEntire != null) {
                        WidgetRemoteAuth.Companion.launch(requireContext(), (String) u.last((List) matchResultMatchEntire.getGroupValues()));
                    } else {
                        UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                    }
                } else {
                    b.a.d.m.i(this, 2131894636, 0, 4);
                }
            }
        } else {
            intentUtils = IntentUtils.INSTANCE;
            m.checkNotNullExpressionValue(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
            if (intentUtils.isDiscordAppUri(uri)) {
                path = uri.getPath();
                if (path != null) {
                    b.a.d.m0.a aVar4 = b.a.d.m0.a.G;
                    Regex regex3 = b.a.d.m0.a.D;
                    m.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = regex3.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    WidgetRemoteAuth.Companion.launch(requireContext(), (String) u.last((List) matchResultMatchEntire.getGroupValues()));
                } else {
                    UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                }
            } else {
                b.a.d.m.i(this, 2131894636, 0, 4);
            }
        }
        requireActivity().finish();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().f2515b.a();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2515b.setFormats(ZXingScannerView.D);
        getBinding().f2515b.setResultHandler(this);
        ZXingScannerView zXingScannerView = getBinding().f2515b;
        m.checkNotNullExpressionValue(zXingScannerView, "binding.qrScanner");
        zXingScannerView.setVisibility(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getColor(this, 2131099689), false, 4, (Object) null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131892651);
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(EXTRA_SHOW_HELP_CHIP, false);
        Chip chip = getBinding().c;
        m.checkNotNullExpressionValue(chip, "binding.qrScannerChip");
        chip.setVisibility(booleanExtra ? 0 : 8);
        requestCameraQRScanner(new WidgetQRScanner$onViewBoundOrOnResume$1(this), new WidgetQRScanner$onViewBoundOrOnResume$2(this));
    }
}
