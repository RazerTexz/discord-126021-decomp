package com.discord.widgets.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.m0.RoutingPatterns;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetQrScannerBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetRemoteAuth;
import com.google.android.material.chip.Chip;
import com.google.zxing.Result;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import e0.a.a.a.CameraHandlerThread;
import e0.a.a.a.CameraHandlerThread2;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQRScanner extends AppFragment implements ZXingScannerView.b {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetQRScanner.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQrScannerBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_HELP_CHIP = "SHOW_HELP_CHIP";
    private static final int MAIN_BACK_CAMERA = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetQRScanner.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            companion.launch(context, z2);
        }

        public final void launch(Context context, boolean showHelpChip) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("android.intent.action.VIEW").putExtra(WidgetQRScanner.EXTRA_SHOW_HELP_CHIP, showHelpChip);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_VIE…_HELP_CHIP, showHelpChip)");
            AppScreen2.d(context, WidgetQRScanner.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetQRScanner.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ZXingScannerView zXingScannerView = WidgetQRScanner.this.getBinding().f2515b;
            if (zXingScannerView.n == null) {
                zXingScannerView.n = new CameraHandlerThread2(zXingScannerView);
            }
            CameraHandlerThread2 cameraHandlerThread2 = zXingScannerView.n;
            Objects.requireNonNull(cameraHandlerThread2);
            new Handler(cameraHandlerThread2.getLooper()).post(new CameraHandlerThread(cameraHandlerThread2, 0));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetQRScanner.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetQRScanner.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    public WidgetQRScanner() {
        super(R.layout.widget_qr_scanner);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetQRScanner2.INSTANCE, new WidgetQRScanner3(this));
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
    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.b
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
            RoutingPatterns routingPatterns = RoutingPatterns.G;
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (routingPatterns.a(uri.getHost())) {
                path = uri.getPath();
                if (path != null) {
                    RoutingPatterns routingPatterns2 = RoutingPatterns.G;
                    Regex regex = RoutingPatterns.D;
                    Intrinsics3.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = regex.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) _Collections.last((List) matchResultMatchEntire.getGroupValues()));
                } else {
                    UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                }
            } else {
                intentUtils = IntentUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                if (intentUtils.isDiscordAppUri(uri)) {
                    path = uri.getPath();
                    if (path != null) {
                        RoutingPatterns routingPatterns3 = RoutingPatterns.G;
                        Regex regex2 = RoutingPatterns.D;
                        Intrinsics3.checkNotNullExpressionValue(path, "it");
                        matchResultMatchEntire = regex2.matchEntire(path);
                    } else {
                        matchResultMatchEntire = null;
                    }
                    if (matchResultMatchEntire != null) {
                        WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) _Collections.last((List) matchResultMatchEntire.getGroupValues()));
                    } else {
                        UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                    }
                } else {
                    AppToast.i(this, R.string.qr_code_invalid, 0, 4);
                }
            }
        } else {
            intentUtils = IntentUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (intentUtils.isDiscordAppUri(uri)) {
                path = uri.getPath();
                if (path != null) {
                    RoutingPatterns routingPatterns4 = RoutingPatterns.G;
                    Regex regex3 = RoutingPatterns.D;
                    Intrinsics3.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = regex3.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) _Collections.last((List) matchResultMatchEntire.getGroupValues()));
                } else {
                    UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                }
            } else {
                AppToast.i(this, R.string.qr_code_invalid, 0, 4);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2515b.setFormats(ZXingScannerView.D);
        getBinding().f2515b.setResultHandler(this);
        ZXingScannerView zXingScannerView = getBinding().f2515b;
        Intrinsics3.checkNotNullExpressionValue(zXingScannerView, "binding.qrScanner");
        zXingScannerView.setVisibility(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getColor(this, R.color.black), false, 4, (Object) null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.login_with_qr);
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(EXTRA_SHOW_HELP_CHIP, false);
        Chip chip = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.qrScannerChip");
        chip.setVisibility(booleanExtra ? 0 : 8);
        requestCameraQRScanner(new AnonymousClass1(), new AnonymousClass2());
    }
}
