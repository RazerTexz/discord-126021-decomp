package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$raw;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsNearbyBinding;
import com.discord.rlottie.RLottieDrawable;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import defpackage.j;
import defpackage.v;
import defpackage.w;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFriendsFindNearby.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private Long meUserId;
    private final NearbyManager nearbyManager;
    private WidgetFriendsAddUserAdapter resultsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetFriendsFindNearby() {
        super(R$layout.widget_friends_nearby);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsFindNearby$binding$2.INSTANCE, null, 2, null);
        WidgetFriendsFindNearby$viewModel$2 widgetFriendsFindNearby$viewModel$2 = WidgetFriendsFindNearby$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetFriendsFindNearbyViewModel.class), new WidgetFriendsFindNearby$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetFriendsFindNearby$viewModel$2));
        this.nearbyManager = new NearbyManager();
        this.captchaLauncher = WidgetCaptcha.Companion.registerForResult(this, new WidgetFriendsFindNearby$captchaLauncher$1(this));
    }

    private final void acceptFriendRequest(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(RestAPI.Companion.getApi(), "Nearby - Accept Friend Request", userId, null, null, null, 28, null), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFriendsFindNearby$acceptFriendRequest$1(this), 62, (Object) null);
    }

    public static final /* synthetic */ void access$acceptFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, long j) {
        widgetFriendsFindNearby.acceptFriendRequest(j);
    }

    public static final /* synthetic */ void access$configureUI(WidgetFriendsFindNearby widgetFriendsFindNearby, WidgetFriendsFindNearby$Model widgetFriendsFindNearby$Model) {
        widgetFriendsFindNearby.configureUI(widgetFriendsFindNearby$Model);
    }

    public static final /* synthetic */ void access$declineFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, long j, boolean z2) {
        widgetFriendsFindNearby.declineFriendRequest(j, z2);
    }

    public static final /* synthetic */ void access$enableScanning(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        widgetFriendsFindNearby.enableScanning();
    }

    public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = widgetFriendsFindNearby.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        return widgetFriendsAddUserAdapter;
    }

    public static final /* synthetic */ WidgetFriendsFindNearbyViewModel access$getViewModel$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        return widgetFriendsFindNearby.getViewModel();
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetFriendsFindNearby widgetFriendsFindNearby, Error error) {
        widgetFriendsFindNearby.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$sendFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetFriendsFindNearby.sendFriendRequest(str, i, captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ void access$setResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby, WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        widgetFriendsFindNearby.resultsAdapter = widgetFriendsAddUserAdapter;
    }

    private final void configureUI(WidgetFriendsFindNearby$Model model) {
        if (model instanceof WidgetFriendsFindNearby$Model$Uninitialized) {
            TextView textView = getBinding().g;
            m.checkNotNullExpressionValue(textView, "binding.nearbyFriendsSearchingTitle");
            textView.setText(getString(2131886348));
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.nearbyFriendsSearchingBody");
            textView2.setText(getString(2131886339));
            TextView textView3 = getBinding().e;
            TextView textView4 = getBinding().e;
            m.checkNotNullExpressionValue(textView4, "binding.nearbyFriendsSearchingBody");
            textView3.setTextColor(ColorCompat.getThemedColor(textView4, 2130968990));
            MaterialButton materialButton = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton, "binding.nearbyFriendsEnable");
            materialButton.setVisibility(0);
            RecyclerView recyclerView = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
            recyclerView.setVisibility(8);
            RLottieImageView rLottieImageView = getBinding().f;
            RLottieDrawable rLottieDrawable = rLottieImageView.drawable;
            if (rLottieDrawable == null) {
                return;
            }
            rLottieImageView.playing = false;
            if (rLottieImageView.attachedToWindow) {
                rLottieDrawable.P = false;
                return;
            }
            return;
        }
        if (model instanceof WidgetFriendsFindNearby$Model$Error) {
            TextView textView5 = getBinding().g;
            m.checkNotNullExpressionValue(textView5, "binding.nearbyFriendsSearchingTitle");
            textView5.setText(getString(2131886348));
            TextView textView6 = getBinding().e;
            m.checkNotNullExpressionValue(textView6, "binding.nearbyFriendsSearchingBody");
            textView6.setText(getErrorMessage(((WidgetFriendsFindNearby$Model$Error) model).getErrorCode()));
            TextView textView7 = getBinding().e;
            TextView textView8 = getBinding().e;
            m.checkNotNullExpressionValue(textView8, "binding.nearbyFriendsSearchingBody");
            textView7.setTextColor(ColorCompat.getColor(textView8, 2131100382));
            MaterialButton materialButton2 = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton2, "binding.nearbyFriendsEnable");
            materialButton2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView2, "binding.nearbyFriendsRecycler");
            recyclerView2.setVisibility(8);
            RLottieImageView rLottieImageView2 = getBinding().f;
            RLottieDrawable rLottieDrawable2 = rLottieImageView2.drawable;
            if (rLottieDrawable2 == null) {
                return;
            }
            rLottieImageView2.playing = false;
            if (rLottieImageView2.attachedToWindow) {
                rLottieDrawable2.P = false;
                return;
            }
            return;
        }
        if (model instanceof WidgetFriendsFindNearby$Model$Empty) {
            TextView textView9 = getBinding().g;
            m.checkNotNullExpressionValue(textView9, "binding.nearbyFriendsSearchingTitle");
            textView9.setText(getString(2131886348));
            TextView textView10 = getBinding().e;
            m.checkNotNullExpressionValue(textView10, "binding.nearbyFriendsSearchingBody");
            textView10.setText(getString(2131886339));
            TextView textView11 = getBinding().e;
            TextView textView12 = getBinding().e;
            m.checkNotNullExpressionValue(textView12, "binding.nearbyFriendsSearchingBody");
            textView11.setTextColor(ColorCompat.getThemedColor(textView12, 2130968990));
            MaterialButton materialButton3 = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton3, "binding.nearbyFriendsEnable");
            materialButton3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView3, "binding.nearbyFriendsRecycler");
            recyclerView3.setVisibility(8);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                return;
            }
            getBinding().f.b();
            return;
        }
        if (model instanceof WidgetFriendsFindNearby$Model$NearbyUsers) {
            TextView textView13 = getBinding().g;
            m.checkNotNullExpressionValue(textView13, "binding.nearbyFriendsSearchingTitle");
            textView13.setText(getString(2131886344));
            TextView textView14 = getBinding().e;
            m.checkNotNullExpressionValue(textView14, "binding.nearbyFriendsSearchingBody");
            textView14.setText(getString(2131886343));
            TextView textView15 = getBinding().e;
            TextView textView16 = getBinding().e;
            m.checkNotNullExpressionValue(textView16, "binding.nearbyFriendsSearchingBody");
            textView15.setTextColor(ColorCompat.getThemedColor(textView16, 2130968990));
            MaterialButton materialButton4 = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton4, "binding.nearbyFriendsEnable");
            materialButton4.setVisibility(8);
            WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
            if (widgetFriendsAddUserAdapter == null) {
                m.throwUninitializedPropertyAccessException("resultsAdapter");
            }
            widgetFriendsAddUserAdapter.setData(((WidgetFriendsFindNearby$Model$NearbyUsers) model).getItems());
            RecyclerView recyclerView4 = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView4, "binding.nearbyFriendsRecycler");
            recyclerView4.setVisibility(0);
        }
    }

    private final void declineFriendRequest(long userId, boolean incomingFriendRequest) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().removeRelationship("Nearby - Remove Friend Request", userId), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFriendsFindNearby$declineFriendRequest$1(this, incomingFriendRequest ? 2131889460 : 2131889455), 62, (Object) null);
    }

    private final void enableScanning() {
        if (this.meUserId == null) {
            updateMeUserIdAndInitNearbyManager();
        }
        if (this.meUserId != null) {
            NearbyManager nearbyManager = this.nearbyManager;
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            nearbyManager.buildClientAndPublish(activity);
        }
    }

    private final WidgetFriendsNearbyBinding getBinding() {
        return (WidgetFriendsNearbyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getErrorMessage(Integer resultCode) {
        if (resultCode != null && resultCode.intValue() == 99) {
            Context context = getContext();
            if (context != null) {
                return context.getString(2131886340);
            }
            return null;
        }
        if (resultCode != null && resultCode.intValue() == 98) {
            Context context2 = getContext();
            if (context2 != null) {
                return context2.getString(2131886347);
            }
            return null;
        }
        Context context3 = getContext();
        if (context3 != null) {
            return context3.getString(2131886345);
        }
        return null;
    }

    private final WidgetFriendsFindNearbyViewModel getViewModel() {
        return (WidgetFriendsFindNearbyViewModel) this.viewModel.getValue();
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.Companion.launch(requireContext(), this.captchaLauncher, CaptchaErrorBody.Companion.createFromError(error));
    }

    private final void sendFriendRequest(String username, int discriminator, CaptchaHelper$CaptchaPayload captchaPayload) {
        getViewModel().setUsername(username);
        getViewModel().setDiscriminator(Integer.valueOf(discriminator));
        ObservableExtensionsKt.ui$default(RestAPI.Companion.getApi().sendRelationshipRequest("Nearby - Add Friend Suggestion", username, discriminator, captchaPayload), this, null, 2, null).k(o.h(new WidgetFriendsFindNearby$sendFriendRequest$1(this, username), getAppActivity(), new WidgetFriendsFindNearby$sendFriendRequest$2(this, username, discriminator)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetFriendsFindNearby.sendFriendRequest(str, i, captchaHelper$CaptchaPayload);
    }

    private final void updateMeUserIdAndInitNearbyManager() {
        long id2 = StoreStream.Companion.getUsers().getMeSnapshot().getId();
        this.meUserId = Long.valueOf(id2);
        this.nearbyManager.initialize(id2);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.nearbyManager.disableNearby();
        super.onPause();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        enableScanning();
        AnalyticsTracker.INSTANCE.friendAddViewed("Nearby");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        updateMeUserIdAndInitNearbyManager();
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = (WidgetFriendsAddUserAdapter) mGRecyclerAdapter$Companion.configure(new WidgetFriendsAddUserAdapter(recyclerView));
        this.resultsAdapter = widgetFriendsAddUserAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter.setSendHandler(new WidgetFriendsFindNearby$onViewBound$1(this));
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter2 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter2.setAcceptHandler(new WidgetFriendsFindNearby$onViewBound$2(this));
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter3 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter3.setDeclineHandler(new WidgetFriendsFindNearby$onViewBound$3(this));
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter4 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter4.setOnItemClick(new WidgetFriendsFindNearby$onViewBound$4(this));
        getBinding().f2399b.setOnClickListener(new WidgetFriendsFindNearby$onViewBound$5(this));
        getBinding().c.setOnClickListener(WidgetFriendsFindNearby$onViewBound$6.INSTANCE);
        getBinding().f.c(R$raw.anim_friends_add_nearby_looking, DimenUtils.dpToPixels(200), DimenUtils.dpToPixels(200));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<R> observableG = storeStream$Companion.getUserRelationships().observeForType(4).G(j.j);
        Observable<R> observableG2 = storeStream$Companion.getUserRelationships().observeForType(3).G(j.k);
        v vVar = v.j;
        Object wVar = vVar;
        if (vVar != null) {
            wVar = new w(vVar);
        }
        Observable observableJ = Observable.j(observableG, observableG2, (Func2) wVar);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…erRequestsModel\n        )");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.ui$default(observableR, this, null, 2, null).k(o.a.g(getContext(), new WidgetFriendsFindNearby$onViewBoundOrOnResume$1(this), null));
        Observable<WidgetFriendsFindNearby$Model> observable = WidgetFriendsFindNearby$ModelProvider.INSTANCE.get(this.nearbyManager.getState());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observable, this, widgetFriendsAddUserAdapter), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFriendsFindNearby$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
