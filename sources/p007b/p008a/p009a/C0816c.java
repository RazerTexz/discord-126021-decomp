package p007b.p008a.p009a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.FileUploadAlertType;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0928c0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.c */
/* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0816c extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f307j = {C1643a.m846d0(C0816c.class, "binding", "getBinding()Lcom/discord/databinding/ImageUploadFailedDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onResendCompressed;

    /* JADX INFO: renamed from: b.a.a.c$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f311j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f312k;

        public a(int i, Object obj) {
            this.f311j = i;
            this.f312k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f311j;
            if (i == 0) {
                Function0<Unit> function0 = ((C0816c) this.f312k).onResendCompressed;
                if (function0 != null) {
                    function0.invoke();
                }
                ((C0816c) this.f312k).dismiss();
                return;
            }
            if (i == 1) {
                ((C0816c) this.f312k).dismiss();
                return;
            }
            if (i == 2) {
                ((C0816c) this.f312k).dismiss();
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    throw null;
                }
                C0816c c0816c = (C0816c) this.f312k;
                KProperty[] kPropertyArr = C0816c.f307j;
                c0816c.m122g().f728c.toggle();
                return;
            }
            AnalyticsTracker.INSTANCE.premiumSettingsOpened(new Traits.Location(null, "File Upload Popout (w/ Compression)", null, null, null, 29, null));
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            C12238m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "it.context");
            WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
            ((C0816c) this.f312k).dismiss();
        }
    }

    /* JADX INFO: renamed from: b.a.a.c$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m123a(FragmentManager fragmentManager, boolean z2, int i, float f, float f2, Function0<Unit> function0, int i2, boolean z3, boolean z4, boolean z5) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            float f3 = 1048576;
            StoreStream.INSTANCE.getAnalytics().trackFileUploadAlertViewed(z2 ? FileUploadAlertType.OVER_MAX_SIZE : FileUploadAlertType.NITRO_UPSELL, i2, (int) (f * f3), (int) (f3 * f2), z3, z4, z2);
            C0816c c0816c = new C0816c();
            c0816c.onResendCompressed = function0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_IS_USER_PREMIUM", z2);
            bundle.putBoolean("PARAM_CAN_COMPRESS", (z4 || z5) ? false : true);
            bundle.putInt("PARAM_MAX_FILE_SIZE_MB", i);
            c0816c.setArguments(bundle);
            c0816c.show(fragmentManager, ImageUploadDialog.class.getName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.c$c */
    /* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C0928c0> {

        /* JADX INFO: renamed from: j */
        public static final c f313j = new c();

        public c() {
            super(1, C0928c0.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ImageUploadFailedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0928c0 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.chat_input_upload_too_large_center_file;
            ImageView imageView = (ImageView) view2.findViewById(C5419R.id.chat_input_upload_too_large_center_file);
            if (imageView != null) {
                i = C5419R.id.image_upload_failed_cancel;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.image_upload_failed_cancel);
                if (materialButton != null) {
                    i = C5419R.id.image_upload_failed_compression_settings_checkbox;
                    SwitchMaterial switchMaterial = (SwitchMaterial) view2.findViewById(C5419R.id.image_upload_failed_compression_settings_checkbox);
                    if (switchMaterial != null) {
                        i = C5419R.id.image_upload_failed_compression_settings_container;
                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(C5419R.id.image_upload_failed_compression_settings_container);
                        if (relativeLayout != null) {
                            i = C5419R.id.image_upload_failed_divider;
                            View viewFindViewById = view2.findViewById(C5419R.id.image_upload_failed_divider);
                            if (viewFindViewById != null) {
                                i = C5419R.id.image_upload_failed_nitro;
                                MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.image_upload_failed_nitro);
                                if (materialButton2 != null) {
                                    i = C5419R.id.image_upload_failed_nitro_wrapper;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(C5419R.id.image_upload_failed_nitro_wrapper);
                                    if (relativeLayout2 != null) {
                                        i = C5419R.id.image_upload_failed_okay;
                                        MaterialButton materialButton3 = (MaterialButton) view2.findViewById(C5419R.id.image_upload_failed_okay);
                                        if (materialButton3 != null) {
                                            i = C5419R.id.image_upload_failed_send_compress;
                                            MaterialButton materialButton4 = (MaterialButton) view2.findViewById(C5419R.id.image_upload_failed_send_compress);
                                            if (materialButton4 != null) {
                                                i = C5419R.id.image_upload_failed_text;
                                                TextView textView = (TextView) view2.findViewById(C5419R.id.image_upload_failed_text);
                                                if (textView != null) {
                                                    i = C5419R.id.setting_label;
                                                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.setting_label);
                                                    if (textView2 != null) {
                                                        i = C5419R.id.setting_subtext;
                                                        TextView textView3 = (TextView) view2.findViewById(C5419R.id.setting_subtext);
                                                        if (textView3 != null) {
                                                            return new C0928c0((RelativeLayout) view2, imageView, materialButton, switchMaterial, relativeLayout, viewFindViewById, materialButton2, relativeLayout2, materialButton3, materialButton4, textView, textView2, textView3);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.c$d */
    /* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
    public static final class d implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a */
        public static final d f314a = new d();

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            StoreStream.INSTANCE.getUserSettings().setIsAutoImageCompressionEnabled(z2);
        }
    }

    public C0816c() {
        super(C5419R.layout.image_upload_failed_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f313j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C0928c0 m122g() {
        return (C0928c0) this.binding.getValue((Fragment) this, f307j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        int i;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int i2 = getArgumentsOrDefault().getInt("PARAM_MAX_FILE_SIZE_MB");
        boolean z2 = getArgumentsOrDefault().getBoolean("PARAM_IS_USER_PREMIUM");
        boolean z3 = this.onResendCompressed != null && getArgumentsOrDefault().getBoolean("PARAM_CAN_COMPRESS");
        if (i2 == 8) {
            i = C5419R.string.file_upload_limit_standard;
        } else if (i2 == 20) {
            i = C5419R.string.file_upload_limit_premium_tier_0;
        } else if (i2 != 50) {
            i = i2 != 100 ? 0 : C5419R.string.file_upload_limit_premium_tier_2;
        } else {
            i = C5419R.string.file_upload_limit_premium_tier_1;
        }
        MaterialButton materialButton = m122g().f734i;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.imageUploadFailedSendCompress");
        materialButton.setVisibility(z3 ? 0 : 8);
        m122g().f734i.setOnClickListener(new a(0, this));
        boolean z4 = z2 && !z3;
        View view2 = m122g().f730e;
        C12238m.checkNotNullExpressionValue(view2, "binding.imageUploadFailedDivider");
        boolean z5 = !z4;
        view2.setVisibility(z5 ? 0 : 8);
        MaterialButton materialButton2 = m122g().f733h;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.imageUploadFailedOkay");
        materialButton2.setVisibility(z4 ? 0 : 8);
        m122g().f733h.setOnClickListener(new a(1, this));
        MaterialButton materialButton3 = m122g().f727b;
        C12238m.checkNotNullExpressionValue(materialButton3, "binding.imageUploadFailedCancel");
        materialButton3.setVisibility(z5 ? 0 : 8);
        m122g().f727b.setOnClickListener(new a(2, this));
        RelativeLayout relativeLayout = m122g().f732g;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.imageUploadFailedNitroWrapper");
        relativeLayout.setVisibility(z2 ^ true ? 0 : 8);
        m122g().f731f.setOnClickListener(new a(3, this));
        RelativeLayout relativeLayout2 = m122g().f729d;
        C12238m.checkNotNullExpressionValue(relativeLayout2, "binding.imageUploadFaile…pressionSettingsContainer");
        relativeLayout2.setVisibility(z3 ? 0 : 8);
        m122g().f729d.setOnClickListener(new a(4, this));
        SwitchMaterial switchMaterial = m122g().f728c;
        C12238m.checkNotNullExpressionValue(switchMaterial, "binding.imageUploadFaile…mpressionSettingsCheckbox");
        switchMaterial.setChecked(StoreStream.INSTANCE.getUserSettings().getIsAutoImageCompressionEnabled());
        m122g().f728c.setOnCheckedChangeListener(d.f314a);
        TextView textView = m122g().f735j;
        C12238m.checkNotNullExpressionValue(textView, "binding.imageUploadFailedText");
        CharSequence charSequenceM210b = null;
        if (z2 || !z3) {
            Context context = getContext();
            if (context != null) {
                Object[] objArr = new Object[1];
                Context context2 = getContext();
                objArr[0] = context2 != null ? C1107b.m210b(context2, i, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null) : null;
                charSequenceM210b = C1107b.m210b(context, C5419R.string.upload_area_too_large_help, objArr, (4 & 4) != 0 ? C1107b.b.f1491j : null);
            }
        } else {
            Context context3 = getContext();
            if (context3 != null) {
                Object[] objArr2 = new Object[1];
                Context context4 = getContext();
                objArr2[0] = context4 != null ? C1107b.m210b(context4, i, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null) : null;
                charSequenceM210b = C1107b.m210b(context3, C5419R.string.upload_area_too_large_help_mobile, objArr2, (4 & 4) != 0 ? C1107b.b.f1491j : null);
            }
        }
        textView.setText(charSequenceM210b);
    }
}
