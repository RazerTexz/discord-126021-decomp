package b.a.a.f.a;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.a0;
import d0.z.d.m;
import defpackage.k;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0)};
    public static final a$b k = new a$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    public a() {
        super(R$layout.audio_output_selection_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, a$c.j, null, 2, null);
        a$e a_e = a$e.j;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(d.class), new k(5, g0Var), new i0(a_e));
    }

    public static final void g(a aVar) {
        Objects.requireNonNull(aVar);
        Observable<Long> observableD0 = Observable.d0(300L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, aVar, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b(aVar), 62, (Object) null);
    }

    public static final d h(a aVar) {
        return (d) aVar.viewModel.getValue();
    }

    public final b.a.i.b i() {
        return (b.a.i.b) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int themedColor = ColorCompat.getThemedColor(view, 2130969008);
        MaterialRadioButton materialRadioButton = i().f80b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionBluetoothRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton, themedColor);
        MaterialRadioButton materialRadioButton2 = i().e;
        m.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionSpeakerRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton2, themedColor);
        MaterialRadioButton materialRadioButton3 = i().f;
        m.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionWiredRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton3, themedColor);
        MaterialRadioButton materialRadioButton4 = i().d;
        m.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionEarpieceRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton4, themedColor);
        i().f80b.setOnClickListener(new a$a(0, this));
        i().e.setOnClickListener(new a$a(1, this));
        i().f.setOnClickListener(new a$a(2, this));
        i().d.setOnClickListener(new a$a(3, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(((d) this.viewModel.getValue()).observeViewState(), this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new a$d(this), 62, (Object) null);
    }
}
