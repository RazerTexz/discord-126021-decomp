package p007b.p008a.p062y;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0921b1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: renamed from: b.a.y.z */
/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1390z extends AbstractC1356l implements AppComponent {

    /* JADX INFO: renamed from: A */
    public final WidgetGlobalSearchAdapter f2077A;

    /* JADX INFO: renamed from: B */
    public final BehaviorSubject<String> f2078B;

    /* JADX INFO: renamed from: C */
    public String f2079C;

    /* JADX INFO: renamed from: z */
    public C0921b1 f2080z;

    /* JADX INFO: renamed from: b.a.y.z$a */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C1390z.this.m387g();
        }
    }

    /* JADX INFO: renamed from: b.a.y.z$b */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class b extends AbstractC12240o implements Function1<Editable, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Editable editable2 = editable;
            C12238m.checkNotNullParameter(editable2, "editable");
            C1390z.this.f2078B.onNext(editable2.toString());
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.y.z$c */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class c<T, R> implements InterfaceC12589b<String, String> {

        /* JADX INFO: renamed from: j */
        public static final c f2082j = new c();

        @Override // p637j0.p641k.InterfaceC12589b
        public String call(String str) {
            return '!' + str;
        }
    }

    /* JADX INFO: renamed from: b.a.y.z$d */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class d extends AbstractC12240o implements Function1<WidgetGlobalSearchModel, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            WidgetGlobalSearchModel widgetGlobalSearchModel2 = widgetGlobalSearchModel;
            C12238m.checkNotNullParameter(widgetGlobalSearchModel2, "it");
            C1390z c1390z = C1390z.this;
            TextView textView = c1390z.f2080z.f699d;
            C12238m.checkNotNullExpressionValue(textView, "binding.emptyResults");
            textView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ? 0 : 8);
            RecyclerView recyclerView = c1390z.f2080z.f701f;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
            recyclerView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ^ true ? 0 : 8);
            WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = c1390z.f2077A;
            widgetGlobalSearchAdapter.setOnUpdated(new C1388x(c1390z, widgetGlobalSearchModel2));
            List<WidgetGlobalSearchModel.ItemDataPayload> data = widgetGlobalSearchModel2.getData();
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                Channel channel = ((WidgetGlobalSearchModel.ItemDataPayload) obj).getChannel();
                if (channel != null && ChannelUtils.m7675J(channel)) {
                    arrayList.add(obj);
                }
            }
            widgetGlobalSearchAdapter.setData(arrayList);
            widgetGlobalSearchAdapter.setOnSelectedListener(new C1389y(c1390z, widgetGlobalSearchModel2));
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1390z(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        getWindowLayoutParams().flags &= -9;
        C0921b1 c0921b1M196a = C0921b1.m196a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(c0921b1M196a, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f2080z = c0921b1M196a;
        RecyclerView recyclerView = this.f2080z.f701f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        this.f2077A = new WidgetGlobalSearchAdapter(recyclerView);
        this.f2078B = BehaviorSubject.m11130l0("");
    }

    @Override // p007b.p008a.p062y.AbstractC1356l
    public Animator getClosingAnimator() {
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), C5419R.animator.overlay_slide_down_fade_out);
        animatorLoadAnimator.setTarget(this.f2080z.f698c);
        C12238m.checkNotNullExpressionValue(animatorLoadAnimator, "AnimatorInflater.loadAni…binding.dialogCard)\n    }");
        return animatorLoadAnimator;
    }

    /* JADX INFO: renamed from: h */
    public final void m393h() {
        this.f2080z.f697b.setOnClickListener(new a());
        TextInputLayout textInputLayout = this.f2080z.f700e;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.overlayChannelSearch");
        ViewExtensions.setText(textInputLayout, this.f2079C);
        TextInputLayout textInputLayout2 = this.f2080z.f700e;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.overlayChannelSearch");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher(null, null, new b(), 3, null));
        }
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.f2077A;
        RecyclerView recyclerView = this.f2080z.f701f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        widgetGlobalSearchAdapter.setRecycler(recyclerView);
        MGRecyclerAdapter.INSTANCE.configure(this.f2077A);
        WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
        Observable<String> observableM11083G = this.f2078B.m11083G(c.f2082j);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filterPublisher.map { \"!$it\" }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(companion.getForNav(observableM11083G), this, this.f2077A), (Class<?>) C1390z.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new d());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m393h();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), C5419R.animator.overlay_slide_up_fade_in);
        animatorLoadAnimator.setTarget(this.f2080z.f698c);
        animatorLoadAnimator.start();
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getUnsubscribeSignal().onNext(null);
        removeAllViewsInLayout();
        C0921b1 c0921b1M196a = C0921b1.m196a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(c0921b1M196a, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f2080z = c0921b1M196a;
        m393h();
    }
}
