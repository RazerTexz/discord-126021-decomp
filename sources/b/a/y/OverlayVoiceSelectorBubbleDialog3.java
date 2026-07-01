package b.a.y;

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
import b.a.i.OverlayVoiceChannelSelectorBinding;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: renamed from: b.a.y.z, reason: use source file name */
/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayVoiceSelectorBubbleDialog3 extends OverlayAppDialog2 implements AppComponent {
    public final WidgetGlobalSearchAdapter A;
    public final BehaviorSubject<String> B;
    public String C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OverlayVoiceChannelSelectorBinding f318z;

    /* JADX INFO: renamed from: b.a.y.z$a */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OverlayVoiceSelectorBubbleDialog3.this.g();
        }
    }

    /* JADX INFO: renamed from: b.a.y.z$b */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class b extends Lambda implements Function1<Editable, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Editable editable2 = editable;
            Intrinsics3.checkNotNullParameter(editable2, "editable");
            OverlayVoiceSelectorBubbleDialog3.this.B.onNext(editable2.toString());
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.y.z$c */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class c<T, R> implements Func1<String, String> {
        public static final c j = new c();

        @Override // j0.k.Func1
        public String call(String str) {
            return '!' + str;
        }
    }

    /* JADX INFO: renamed from: b.a.y.z$d */
    /* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class d extends Lambda implements Function1<WidgetGlobalSearchModel, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            WidgetGlobalSearchModel widgetGlobalSearchModel2 = widgetGlobalSearchModel;
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchModel2, "it");
            OverlayVoiceSelectorBubbleDialog3 overlayVoiceSelectorBubbleDialog3 = OverlayVoiceSelectorBubbleDialog3.this;
            TextView textView = overlayVoiceSelectorBubbleDialog3.f318z.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyResults");
            textView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ? 0 : 8);
            RecyclerView recyclerView = overlayVoiceSelectorBubbleDialog3.f318z.f;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
            recyclerView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ^ true ? 0 : 8);
            WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = overlayVoiceSelectorBubbleDialog3.A;
            widgetGlobalSearchAdapter.setOnUpdated(new OverlayVoiceSelectorBubbleDialog(overlayVoiceSelectorBubbleDialog3, widgetGlobalSearchModel2));
            List<WidgetGlobalSearchModel.ItemDataPayload> data = widgetGlobalSearchModel2.getData();
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                Channel channel = ((WidgetGlobalSearchModel.ItemDataPayload) obj).getChannel();
                if (channel != null && ChannelUtils.J(channel)) {
                    arrayList.add(obj);
                }
            }
            widgetGlobalSearchAdapter.setData(arrayList);
            widgetGlobalSearchAdapter.setOnSelectedListener(new OverlayVoiceSelectorBubbleDialog2(overlayVoiceSelectorBubbleDialog3, widgetGlobalSearchModel2));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayVoiceSelectorBubbleDialog3(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        getWindowLayoutParams().flags &= -9;
        OverlayVoiceChannelSelectorBinding overlayVoiceChannelSelectorBindingA = OverlayVoiceChannelSelectorBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(overlayVoiceChannelSelectorBindingA, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f318z = overlayVoiceChannelSelectorBindingA;
        RecyclerView recyclerView = this.f318z.f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        this.A = new WidgetGlobalSearchAdapter(recyclerView);
        this.B = BehaviorSubject.l0("");
    }

    @Override // b.a.y.OverlayAppDialog2
    public Animator getClosingAnimator() {
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_down_fade_out);
        animatorLoadAnimator.setTarget(this.f318z.c);
        Intrinsics3.checkNotNullExpressionValue(animatorLoadAnimator, "AnimatorInflater.loadAni…binding.dialogCard)\n    }");
        return animatorLoadAnimator;
    }

    public final void h() {
        this.f318z.f82b.setOnClickListener(new a());
        TextInputLayout textInputLayout = this.f318z.e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.overlayChannelSearch");
        ViewExtensions.setText(textInputLayout, this.C);
        TextInputLayout textInputLayout2 = this.f318z.e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.overlayChannelSearch");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher(null, null, new b(), 3, null));
        }
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.A;
        RecyclerView recyclerView = this.f318z.f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        widgetGlobalSearchAdapter.setRecycler(recyclerView);
        MGRecyclerAdapter.INSTANCE.configure(this.A);
        WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
        Observable<String> observableG = this.B.G(c.j);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filterPublisher.map { \"!$it\" }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(companion.getForNav(observableG), this, this.A), (Class<?>) OverlayVoiceSelectorBubbleDialog3.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new d());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_up_fade_in);
        animatorLoadAnimator.setTarget(this.f318z.c);
        animatorLoadAnimator.start();
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getUnsubscribeSignal().onNext(null);
        removeAllViewsInLayout();
        OverlayVoiceChannelSelectorBinding overlayVoiceChannelSelectorBindingA = OverlayVoiceChannelSelectorBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(overlayVoiceChannelSelectorBindingA, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f318z = overlayVoiceChannelSelectorBindingA;
        h();
    }
}
