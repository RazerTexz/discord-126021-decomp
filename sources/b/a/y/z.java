package b.a.y;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.b1;
import com.discord.app.AppComponent;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z extends l implements AppComponent {
    public final WidgetGlobalSearchAdapter A;
    public final BehaviorSubject<String> B;
    public String C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b1 f318z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context) {
        super(context);
        d0.z.d.m.checkNotNullParameter(context, "context");
        getWindowLayoutParams().flags &= -9;
        b1 b1VarA = b1.a(LayoutInflater.from(getContext()), this, true);
        d0.z.d.m.checkNotNullExpressionValue(b1VarA, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f318z = b1VarA;
        RecyclerView recyclerView = this.f318z.f;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        this.A = new WidgetGlobalSearchAdapter(recyclerView);
        this.B = BehaviorSubject.l0("");
    }

    @Override // b.a.y.l
    public Animator getClosingAnimator() {
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), 2130837533);
        animatorLoadAnimator.setTarget(this.f318z.c);
        d0.z.d.m.checkNotNullExpressionValue(animatorLoadAnimator, "AnimatorInflater.loadAni…binding.dialogCard)\n    }");
        return animatorLoadAnimator;
    }

    public final void h() {
        this.f318z.f82b.setOnClickListener(new z$a(this));
        TextInputLayout textInputLayout = this.f318z.e;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.overlayChannelSearch");
        ViewExtensions.setText(textInputLayout, this.C);
        TextInputLayout textInputLayout2 = this.f318z.e;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout2, "binding.overlayChannelSearch");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher(null, null, new z$b(this), 3, null));
        }
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.A;
        RecyclerView recyclerView = this.f318z.f;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        widgetGlobalSearchAdapter.setRecycler(recyclerView);
        MGRecyclerAdapter.Companion.configure(this.A);
        WidgetGlobalSearchModel$Companion widgetGlobalSearchModel$Companion = WidgetGlobalSearchModel.Companion;
        Observable<String> observableG = this.B.G(z$c.j);
        d0.z.d.m.checkNotNullExpressionValue(observableG, "filterPublisher.map { \"!$it\" }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(widgetGlobalSearchModel$Companion.getForNav(observableG), this, this.A), z.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new z$d(this), 62, (Object) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), 2130837534);
        animatorLoadAnimator.setTarget(this.f318z.c);
        animatorLoadAnimator.start();
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getUnsubscribeSignal().onNext(null);
        removeAllViewsInLayout();
        b1 b1VarA = b1.a(LayoutInflater.from(getContext()), this, true);
        d0.z.d.m.checkNotNullExpressionValue(b1VarA, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f318z = b1VarA;
        h();
    }
}
