package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsNearbyBinding;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.rlottie.RLottieDrawable;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12574j;
import p000.C13174v;
import p000.C13175w;
import p000.WidgetFriendsAddUserRequestsModel;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetFriendsFindNearby.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private Long meUserId;
    private final NearbyManager nearbyManager;
    private WidgetFriendsAddUserAdapter resultsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static abstract class Model {

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final class Empty extends Model {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final /* data */ class Error extends Model {
            private final Integer errorCode;

            public Error(Integer num) {
                super(null);
                this.errorCode = num;
            }

            public static /* synthetic */ Error copy$default(Error error, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = error.errorCode;
                }
                return error.copy(num);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public final Error copy(Integer errorCode) {
                return new Error(errorCode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && C12238m.areEqual(this.errorCode, ((Error) other).errorCode);
                }
                return true;
            }

            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public int hashCode() {
                Integer num = this.errorCode;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m818F(C1643a.m833U("Error(errorCode="), this.errorCode, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final /* data */ class NearbyUsers extends Model {
            private final List<WidgetFriendsAddUserAdapter.ItemUser> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NearbyUsers(List<WidgetFriendsAddUserAdapter.ItemUser> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ NearbyUsers copy$default(NearbyUsers nearbyUsers, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = nearbyUsers.items;
                }
                return nearbyUsers.copy(list);
            }

            public final List<WidgetFriendsAddUserAdapter.ItemUser> component1() {
                return this.items;
            }

            public final NearbyUsers copy(List<WidgetFriendsAddUserAdapter.ItemUser> items) {
                C12238m.checkNotNullParameter(items, "items");
                return new NearbyUsers(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof NearbyUsers) && C12238m.areEqual(this.items, ((NearbyUsers) other).items);
                }
                return true;
            }

            public final List<WidgetFriendsAddUserAdapter.ItemUser> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<WidgetFriendsAddUserAdapter.ItemUser> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("NearbyUsers(items="), this.items, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final class Uninitialized extends Model {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        private final Observable<Model.NearbyUsers> getUserModels(Collection<Long> userIds) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model.NearbyUsers> observableM11075i = Observable.m11075i(companion.getUsers().observeUsers(userIds, true), companion.getPresences().observePresencesForUsers(userIds), companion.getUserRelationships().observe(userIds), new Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Model.NearbyUsers>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$getUserModels$1
                @Override // p658rx.functions.Func3
                public /* bridge */ /* synthetic */ WidgetFriendsFindNearby.Model.NearbyUsers call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends Integer> map3) {
                    return call2(map, (Map<Long, Presence>) map2, (Map<Long, Integer>) map3);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetFriendsFindNearby.Model.NearbyUsers call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3) {
                    C12238m.checkNotNullExpressionValue(map, "users");
                    ArrayList arrayList = new ArrayList(map.size());
                    for (Map.Entry<Long, ? extends User> entry : map.entrySet()) {
                        long jLongValue = entry.getKey().longValue();
                        User value = entry.getValue();
                        List listEmptyList = C12147n.emptyList();
                        Presence presence = map2.get(Long.valueOf(jLongValue));
                        Integer num = map3.get(Long.valueOf(jLongValue));
                        boolean z2 = true;
                        if (num == null || num.intValue() != 1) {
                            z2 = false;
                        }
                        arrayList.add(new WidgetFriendsAddUserAdapter.ItemUser(value, listEmptyList, presence, z2));
                    }
                    return new WidgetFriendsFindNearby.Model.NearbyUsers(arrayList);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11075i, "Observable\n          .co…yUsers(items)\n          }");
            return observableM11075i;
        }

        public final Observable<Model> get(Observable<NearbyManager.NearbyState> nearbyStateObservable) {
            C12238m.checkNotNullParameter(nearbyStateObservable, "nearbyStateObservable");
            Observable observableM11099Y = nearbyStateObservable.m11099Y(new InterfaceC12589b<NearbyManager.NearbyState, Observable<? extends Model>>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$get$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetFriendsFindNearby.Model> call(NearbyManager.NearbyState nearbyState) {
                    C12721k c12721k;
                    if (nearbyState instanceof NearbyManager.NearbyState.Disconnected) {
                        return new C12721k(new WidgetFriendsFindNearby.Model.Error(Integer.valueOf(((NearbyManager.NearbyState.Disconnected) nearbyState).getCode())));
                    }
                    if (nearbyState instanceof NearbyManager.NearbyState.Uninitialized) {
                        c12721k = new C12721k(WidgetFriendsFindNearby.Model.Uninitialized.INSTANCE);
                    } else {
                        if (!(nearbyState instanceof NearbyManager.NearbyState.Connected)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        NearbyManager.NearbyState.Connected connected = (NearbyManager.NearbyState.Connected) nearbyState;
                        if (!connected.getNearbyUserIds().isEmpty()) {
                            return WidgetFriendsFindNearby.ModelProvider.INSTANCE.getUserModels(connected.getNearbyUserIds());
                        }
                        c12721k = new C12721k(WidgetFriendsFindNearby.Model.Empty.INSTANCE);
                    }
                    return c12721k;
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "nearbyStateObservable\n  …          }\n            }");
            return observableM11099Y;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$acceptFriendRequest$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83861 extends AbstractC12240o implements Function1<Void, Unit> {
        public C83861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            C0876m.m169g(WidgetFriendsFindNearby.this.getContext(), C5419R.string.accept_request_button_after, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$declineFriendRequest$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83871 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83871(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            C0876m.m169g(WidgetFriendsFindNearby.this.getContext(), this.$successMessageStringRes, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83881 extends AbstractC12240o implements Function2<String, Integer, Unit> {
        public C83881() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
            invoke(str, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(String str, int i) {
            C12238m.checkNotNullParameter(str, "username");
            WidgetFriendsFindNearby.sendFriendRequest$default(WidgetFriendsFindNearby.this, str, i, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83892 extends AbstractC12240o implements Function1<Long, Unit> {
        public C83892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetFriendsFindNearby.this.acceptFriendRequest(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83903 extends AbstractC12240o implements Function2<Long, Boolean, Unit> {
        public C83903() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetFriendsFindNearby.this.declineFriendRequest(j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83914 extends AbstractC12240o implements Function1<Long, Unit> {
        public C83914() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetFriendsFindNearby.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83941 extends AbstractC12240o implements Function1<WidgetFriendsAddUserRequestsModel, Unit> {
        public C83941() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            invoke2(widgetFriendsAddUserRequestsModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            WidgetFriendsFindNearby.access$getResultsAdapter$p(WidgetFriendsFindNearby.this).addFriendRequestUserIds(widgetFriendsAddUserRequestsModel.outgoingIds, widgetFriendsAddUserRequestsModel.incomingIds);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83952 extends AbstractC12240o implements Function1<Model, Unit> {
        public C83952() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "it");
            WidgetFriendsFindNearby.this.configureUI(model);
        }
    }

    public WidgetFriendsFindNearby() {
        super(C5419R.layout.widget_friends_nearby);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsFindNearby$binding$2.INSTANCE, null, 2, null);
        WidgetFriendsFindNearby$viewModel$2 widgetFriendsFindNearby$viewModel$2 = WidgetFriendsFindNearby$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetFriendsFindNearbyViewModel.class), new WidgetFriendsFindNearby$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetFriendsFindNearby$viewModel$2));
        this.nearbyManager = new NearbyManager();
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetFriendsFindNearby$captchaLauncher$1(this));
    }

    private final void acceptFriendRequest(long userId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().addRelationship("Nearby - Accept Friend Request", userId, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null), false, 1, null), this, null, 2, null), (Class<?>) WidgetFriendsFindNearby.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83861());
    }

    public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = widgetFriendsFindNearby.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        return widgetFriendsAddUserAdapter;
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Uninitialized) {
            TextView textView = getBinding().f16692g;
            C12238m.checkNotNullExpressionValue(textView, "binding.nearbyFriendsSearchingTitle");
            textView.setText(getString(C5419R.string.add_friend_nearby_title));
            TextView textView2 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.nearbyFriendsSearchingBody");
            textView2.setText(getString(C5419R.string.add_friend_nearby_body));
            TextView textView3 = getBinding().f16690e;
            TextView textView4 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.nearbyFriendsSearchingBody");
            textView3.setTextColor(ColorCompat.getThemedColor(textView4, C5419R.attr.colorHeaderSecondary));
            MaterialButton materialButton = getBinding().f16687b;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.nearbyFriendsEnable");
            materialButton.setVisibility(0);
            RecyclerView recyclerView = getBinding().f16689d;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
            recyclerView.setVisibility(8);
            RLottieImageView rLottieImageView = getBinding().f16691f;
            RLottieDrawable rLottieDrawable = rLottieImageView.drawable;
            if (rLottieDrawable == null) {
                return;
            }
            rLottieImageView.playing = false;
            if (rLottieImageView.attachedToWindow) {
                rLottieDrawable.f18711P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Error) {
            TextView textView5 = getBinding().f16692g;
            C12238m.checkNotNullExpressionValue(textView5, "binding.nearbyFriendsSearchingTitle");
            textView5.setText(getString(C5419R.string.add_friend_nearby_title));
            TextView textView6 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView6, "binding.nearbyFriendsSearchingBody");
            textView6.setText(getErrorMessage(((Model.Error) model).getErrorCode()));
            TextView textView7 = getBinding().f16690e;
            TextView textView8 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView8, "binding.nearbyFriendsSearchingBody");
            textView7.setTextColor(ColorCompat.getColor(textView8, C5419R.color.status_red_500));
            MaterialButton materialButton2 = getBinding().f16687b;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.nearbyFriendsEnable");
            materialButton2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().f16689d;
            C12238m.checkNotNullExpressionValue(recyclerView2, "binding.nearbyFriendsRecycler");
            recyclerView2.setVisibility(8);
            RLottieImageView rLottieImageView2 = getBinding().f16691f;
            RLottieDrawable rLottieDrawable2 = rLottieImageView2.drawable;
            if (rLottieDrawable2 == null) {
                return;
            }
            rLottieImageView2.playing = false;
            if (rLottieImageView2.attachedToWindow) {
                rLottieDrawable2.f18711P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Empty) {
            TextView textView9 = getBinding().f16692g;
            C12238m.checkNotNullExpressionValue(textView9, "binding.nearbyFriendsSearchingTitle");
            textView9.setText(getString(C5419R.string.add_friend_nearby_title));
            TextView textView10 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView10, "binding.nearbyFriendsSearchingBody");
            textView10.setText(getString(C5419R.string.add_friend_nearby_body));
            TextView textView11 = getBinding().f16690e;
            TextView textView12 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView12, "binding.nearbyFriendsSearchingBody");
            textView11.setTextColor(ColorCompat.getThemedColor(textView12, C5419R.attr.colorHeaderSecondary));
            MaterialButton materialButton3 = getBinding().f16687b;
            C12238m.checkNotNullExpressionValue(materialButton3, "binding.nearbyFriendsEnable");
            materialButton3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().f16689d;
            C12238m.checkNotNullExpressionValue(recyclerView3, "binding.nearbyFriendsRecycler");
            recyclerView3.setVisibility(8);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                return;
            }
            getBinding().f16691f.m8449b();
            return;
        }
        if (model instanceof Model.NearbyUsers) {
            TextView textView13 = getBinding().f16692g;
            C12238m.checkNotNullExpressionValue(textView13, "binding.nearbyFriendsSearchingTitle");
            textView13.setText(getString(C5419R.string.add_friend_nearby_found_title));
            TextView textView14 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView14, "binding.nearbyFriendsSearchingBody");
            textView14.setText(getString(C5419R.string.add_friend_nearby_found_body));
            TextView textView15 = getBinding().f16690e;
            TextView textView16 = getBinding().f16690e;
            C12238m.checkNotNullExpressionValue(textView16, "binding.nearbyFriendsSearchingBody");
            textView15.setTextColor(ColorCompat.getThemedColor(textView16, C5419R.attr.colorHeaderSecondary));
            MaterialButton materialButton4 = getBinding().f16687b;
            C12238m.checkNotNullExpressionValue(materialButton4, "binding.nearbyFriendsEnable");
            materialButton4.setVisibility(8);
            WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
            if (widgetFriendsAddUserAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
            }
            widgetFriendsAddUserAdapter.setData(((Model.NearbyUsers) model).getItems());
            RecyclerView recyclerView4 = getBinding().f16689d;
            C12238m.checkNotNullExpressionValue(recyclerView4, "binding.nearbyFriendsRecycler");
            recyclerView4.setVisibility(0);
        }
    }

    private final void declineFriendRequest(long userId, boolean incomingFriendRequest) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeRelationship("Nearby - Remove Friend Request", userId), false, 1, null), this, null, 2, null), (Class<?>) WidgetFriendsFindNearby.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83871(incomingFriendRequest ? C5419R.string.friend_request_ignored : C5419R.string.friend_request_cancelled));
    }

    private final void enableScanning() {
        if (this.meUserId == null) {
            updateMeUserIdAndInitNearbyManager();
        }
        if (this.meUserId != null) {
            NearbyManager nearbyManager = this.nearbyManager;
            FragmentActivity fragmentActivityM95e = m95e();
            Objects.requireNonNull(fragmentActivityM95e, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            nearbyManager.buildClientAndPublish(fragmentActivityM95e);
        }
    }

    private final WidgetFriendsNearbyBinding getBinding() {
        return (WidgetFriendsNearbyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getErrorMessage(Integer resultCode) {
        if (resultCode != null && resultCode.intValue() == 99) {
            Context context = getContext();
            if (context != null) {
                return context.getString(C5419R.string.add_friend_nearby_connection_error);
            }
            return null;
        }
        if (resultCode != null && resultCode.intValue() == 98) {
            Context context2 = getContext();
            if (context2 != null) {
                return context2.getString(C5419R.string.add_friend_nearby_stopped);
            }
            return null;
        }
        Context context3 = getContext();
        if (context3 != null) {
            return context3.getString(C5419R.string.add_friend_nearby_generic_error);
        }
        return null;
    }

    private final WidgetFriendsFindNearbyViewModel getViewModel() {
        return (WidgetFriendsFindNearbyViewModel) this.viewModel.getValue();
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.INSTANCE.launch(requireContext(), this.captchaLauncher, CaptchaErrorBody.INSTANCE.createFromError(error));
    }

    private final void sendFriendRequest(final String username, final int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        getViewModel().setUsername(username);
        getViewModel().setDiscriminator(Integer.valueOf(discriminator));
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Nearby - Add Friend Suggestion", username, discriminator, captchaPayload), this, null, 2, null).m11108k(C0879o.m181h(new Action1<Void>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.sendFriendRequest.1
            @Override // p658rx.functions.Action1
            public final void call(Void r7) {
                Context context = WidgetFriendsFindNearby.this.getContext();
                Context context2 = WidgetFriendsFindNearby.this.getContext();
                C0876m.m170h(context, context2 != null ? C1107b.m216h(context2, C5419R.string.add_friend_confirmation, new Object[]{username}, null, 4) : null, 0, null, 12);
            }
        }, getAppActivity(), new Action1<Error>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.sendFriendRequest.2

            /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ Error $error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(Error error) {
                    super(0);
                    this.$error = error;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Error error = this.$error;
                    C12238m.checkNotNullExpressionValue(error, "error");
                    if (WidgetCaptchaKt.isCaptchaError(error)) {
                        WidgetFriendsFindNearby widgetFriendsFindNearby = WidgetFriendsFindNearby.this;
                        Error error2 = this.$error;
                        C12238m.checkNotNullExpressionValue(error2, "error");
                        widgetFriendsFindNearby.launchCaptchaFlow(error2);
                        return;
                    }
                    RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                    Context context = WidgetFriendsFindNearby.this.getContext();
                    Error error3 = this.$error;
                    C12238m.checkNotNullExpressionValue(error3, "error");
                    Error.Response response = error3.getResponse();
                    C12238m.checkNotNullExpressionValue(response, "error.response");
                    C0876m.m170h(WidgetFriendsFindNearby.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), username + MentionUtilsKt.CHANNELS_CHAR + UserUtils.INSTANCE.padDiscriminator(discriminator)), 0, null, 12);
                }
            }

            @Override // p658rx.functions.Action1
            public final void call(Error error) {
                RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
                C12238m.checkNotNullExpressionValue(error, "error");
                RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new AnonymousClass1(error), null, 4, null);
            }
        }));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        widgetFriendsFindNearby.sendFriendRequest(str, i, captchaPayload);
    }

    private final void updateMeUserIdAndInitNearbyManager() {
        long id2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        updateMeUserIdAndInitNearbyManager();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16689d;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = (WidgetFriendsAddUserAdapter) companion.configure(new WidgetFriendsAddUserAdapter(recyclerView));
        this.resultsAdapter = widgetFriendsAddUserAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter.setSendHandler(new C83881());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter2 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter2.setAcceptHandler(new C83892());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter3 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter3.setDeclineHandler(new C83903());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter4 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter4 == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter4.setOnItemClick(new C83914());
        getBinding().f16687b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetFriendsFindNearby.this.enableScanning();
            }
        });
        getBinding().f16688c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.onViewBound.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m885x(view2, "it", "it.context"), C0862f.f507a.m149a(360014894392L, null), false, false, null, 28, null);
            }
        });
        getBinding().f16691f.m8450c(C5419R.raw.anim_friends_add_nearby_looking, DimenUtils.dpToPixels(200), DimenUtils.dpToPixels(200));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<R> observableM11083G = companion.getUserRelationships().observeForType(4).m11083G(C12574j.f26680j);
        Observable<R> observableM11083G2 = companion.getUserRelationships().observeForType(3).m11083G(C12574j.f26681k);
        C13174v c13174v = C13174v.f27929j;
        Object c13175w = c13174v;
        if (c13174v != null) {
            c13175w = new C13175w(c13174v);
        }
        Observable observableM11076j = Observable.m11076j(observableM11083G, observableM11083G2, (Func2) c13175w);
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…erRequestsModel\n        )");
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null).m11108k(C0879o.f566a.m184g(getContext(), new C83941(), null));
        Observable<Model> observable = ModelProvider.INSTANCE.get(this.nearbyManager.getState());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(observable, this, widgetFriendsAddUserAdapter), (Class<?>) WidgetFriendsFindNearby.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83952());
    }
}
