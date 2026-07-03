package com.discord.widgets.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
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
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.p019m0.C0877a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p596e0.p597a.p598a.p599a.HandlerThreadC12255c;
import p596e0.p597a.p598a.p599a.RunnableC12254b;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQRScanner extends AppFragment implements ZXingScannerView.InterfaceC12927b {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetQRScanner.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQrScannerBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("android.intent.action.VIEW").putExtra(WidgetQRScanner.EXTRA_SHOW_HELP_CHIP, showHelpChip);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_VIE…_HELP_CHIP, showHelpChip)");
            C0870j.m156d(context, WidgetQRScanner.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetQRScanner.kt */
    public static final class C90681 extends AbstractC12240o implements Function0<Unit> {
        public C90681() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ZXingScannerView zXingScannerView = WidgetQRScanner.this.getBinding().f17396b;
            if (zXingScannerView.f25303n == null) {
                zXingScannerView.f25303n = new HandlerThreadC12255c(zXingScannerView);
            }
            HandlerThreadC12255c handlerThreadC12255c = zXingScannerView.f25303n;
            Objects.requireNonNull(handlerThreadC12255c);
            new Handler(handlerThreadC12255c.getLooper()).post(new RunnableC12254b(handlerThreadC12255c, 0));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetQRScanner.kt */
    public static final class C90692 extends AbstractC12240o implements Function0<Unit> {
        public C90692() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
        super(C5419R.layout.widget_qr_scanner);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetQRScanner$binding$2.INSTANCE, new WidgetQRScanner$binding$3(this));
    }

    private final WidgetQrScannerBinding getBinding() {
        return (WidgetQrScannerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetQrScannerBinding binding) {
        binding.f17396b.m10094a();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    /* JADX WARN: Code duplicated, block: B:17:0x0058  */
    /* JADX WARN: Code duplicated, block: B:18:0x0068  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.InterfaceC12927b
    public void handleResult(Result rawResult) {
        String str;
        IntentUtils intentUtils;
        String path;
        MatchResult matchResultMatchEntire;
        if (rawResult == null || (str = rawResult.f21668a) == null) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (URLUtil.isValidUrl(str)) {
            C0877a c0877a = C0877a.f538G;
            C12238m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (c0877a.m173a(uri.getHost())) {
                path = uri.getPath();
                if (path != null) {
                    C0877a c0877a2 = C0877a.f538G;
                    Regex regex = C0877a.f535D;
                    C12238m.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = regex.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) C12163u.last((List) matchResultMatchEntire.getGroupValues()));
                } else {
                    UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                }
            } else {
                intentUtils = IntentUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                if (intentUtils.isDiscordAppUri(uri)) {
                    path = uri.getPath();
                    if (path != null) {
                        C0877a c0877a3 = C0877a.f538G;
                        Regex regex2 = C0877a.f535D;
                        C12238m.checkNotNullExpressionValue(path, "it");
                        matchResultMatchEntire = regex2.matchEntire(path);
                    } else {
                        matchResultMatchEntire = null;
                    }
                    if (matchResultMatchEntire != null) {
                        WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) C12163u.last((List) matchResultMatchEntire.getGroupValues()));
                    } else {
                        UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                    }
                } else {
                    C0876m.m171i(this, C5419R.string.qr_code_invalid, 0, 4);
                }
            }
        } else {
            intentUtils = IntentUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (intentUtils.isDiscordAppUri(uri)) {
                path = uri.getPath();
                if (path != null) {
                    C0877a c0877a4 = C0877a.f538G;
                    Regex regex3 = C0877a.f535D;
                    C12238m.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = regex3.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) C12163u.last((List) matchResultMatchEntire.getGroupValues()));
                } else {
                    UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                }
            } else {
                C0876m.m171i(this, C5419R.string.qr_code_invalid, 0, 4);
            }
        }
        requireActivity().finish();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().f17396b.m10094a();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17396b.setFormats(ZXingScannerView.f27495D);
        getBinding().f17396b.setResultHandler(this);
        ZXingScannerView zXingScannerView = getBinding().f17396b;
        C12238m.checkNotNullExpressionValue(zXingScannerView, "binding.qrScanner");
        zXingScannerView.setVisibility(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getColor(this, C5419R.color.black), false, 4, (Object) null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.login_with_qr);
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(EXTRA_SHOW_HELP_CHIP, false);
        Chip chip = getBinding().f17397c;
        C12238m.checkNotNullExpressionValue(chip, "binding.qrScannerChip");
        chip.setVisibility(booleanExtra ? 0 : 8);
        requestCameraQRScanner(new C90681(), new C90692());
    }
}
