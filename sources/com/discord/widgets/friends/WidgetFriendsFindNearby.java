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
import b.a.d.AppHelpDesk;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.friends.NearbyManager;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import com.discord.widgets.friends.WidgetFriendsFindNearby;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.button.MaterialButton;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.WidgetFriendsAddUserRequestsModel;
import defpackage.WidgetFriendsAddUserRequestsModel2;
import defpackage.WidgetFriendsAddUserRequestsModel3;
import defpackage.j;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFriendsFindNearby.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0)};

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
                    return (other instanceof Error) && Intrinsics3.areEqual(this.errorCode, ((Error) other).errorCode);
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
                return outline.F(outline.U("Error(errorCode="), this.errorCode, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final /* data */ class NearbyUsers extends Model {
            private final List<WidgetFriendsAddUserAdapter.ItemUser> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NearbyUsers(List<WidgetFriendsAddUserAdapter.ItemUser> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
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
                Intrinsics3.checkNotNullParameter(items, "items");
                return new NearbyUsers(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof NearbyUsers) && Intrinsics3.areEqual(this.items, ((NearbyUsers) other).items);
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
                return outline.L(outline.U("NearbyUsers(items="), this.items, ")");
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
            Observable<Model.NearbyUsers> observableI = Observable.i(companion.getUsers().observeUsers(userIds, true), companion.getPresences().observePresencesForUsers(userIds), companion.getUserRelationships().observe(userIds), new Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Model.NearbyUsers>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$getUserModels$1
                @Override // rx.functions.Func3
                public /* bridge */ /* synthetic */ WidgetFriendsFindNearby.Model.NearbyUsers call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends Integer> map3) {
                    return call2(map, (Map<Long, Presence>) map2, (Map<Long, Integer>) map3);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetFriendsFindNearby.Model.NearbyUsers call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3) {
                    Intrinsics3.checkNotNullExpressionValue(map, "users");
                    ArrayList arrayList = new ArrayList(map.size());
                    for (Map.Entry<Long, ? extends User> entry : map.entrySet()) {
                        long jLongValue = entry.getKey().longValue();
                        User value = entry.getValue();
                        List listEmptyList = Collections2.emptyList();
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
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n          .co…yUsers(items)\n          }");
            return observableI;
        }

        public final Observable<Model> get(Observable<NearbyManager.NearbyState> nearbyStateObservable) {
            Intrinsics3.checkNotNullParameter(nearbyStateObservable, "nearbyStateObservable");
            Observable observableY = nearbyStateObservable.Y(new Func1<NearbyManager.NearbyState, Observable<? extends Model>>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$get$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetFriendsFindNearby.Model> call(NearbyManager.NearbyState nearbyState) {
                    ScalarSynchronousObservable scalarSynchronousObservable;
                    if (nearbyState instanceof NearbyManager.NearbyState.Disconnected) {
                        return new ScalarSynchronousObservable(new WidgetFriendsFindNearby.Model.Error(Integer.valueOf(((NearbyManager.NearbyState.Disconnected) nearbyState).getCode())));
                    }
                    if (nearbyState instanceof NearbyManager.NearbyState.Uninitialized) {
                        scalarSynchronousObservable = new ScalarSynchronousObservable(WidgetFriendsFindNearby.Model.Uninitialized.INSTANCE);
                    } else {
                        if (!(nearbyState instanceof NearbyManager.NearbyState.Connected)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        NearbyManager.NearbyState.Connected connected = (NearbyManager.NearbyState.Connected) nearbyState;
                        if (!connected.getNearbyUserIds().isEmpty()) {
                            return WidgetFriendsFindNearby.ModelProvider.INSTANCE.getUserModels(connected.getNearbyUserIds());
                        }
                        scalarSynchronousObservable = new ScalarSynchronousObservable(WidgetFriendsFindNearby.Model.Empty.INSTANCE);
                    }
                    return scalarSynchronousObservable;
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "nearbyStateObservable\n  …          }\n            }");
            return observableY;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$acceptFriendRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            AppToast.g(WidgetFriendsFindNearby.this.getContext(), R.string.accept_request_button_after, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$declineFriendRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            AppToast.g(WidgetFriendsFindNearby.this.getContext(), this.$successMessageStringRes, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<String, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
            invoke(str, num.intValue());
            return Unit.a;
        }

        public final void invoke(String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "username");
            WidgetFriendsFindNearby.sendFriendRequest$default(WidgetFriendsFindNearby.this, str, i, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetFriendsFindNearby.this.acceptFriendRequest(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, Boolean, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetFriendsFindNearby.this.declineFriendRequest(j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetFriendsFindNearby.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetFriendsAddUserRequestsModel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            invoke2(widgetFriendsAddUserRequestsModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            WidgetFriendsFindNearby.access$getResultsAdapter$p(WidgetFriendsFindNearby.this).addFriendRequestUserIds(widgetFriendsAddUserRequestsModel.outgoingIds, widgetFriendsAddUserRequestsModel.incomingIds);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetFriendsFindNearby.this.configureUI(model);
        }
    }

    public WidgetFriendsFindNearby() {
        super(R.layout.widget_friends_nearby);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsFindNearby4.INSTANCE, null, 2, null);
        WidgetFriendsFindNearby6 widgetFriendsFindNearby6 = WidgetFriendsFindNearby6.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetFriendsFindNearbyViewModel.class), new WidgetFriendsFindNearby$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFriendsFindNearby6));
        this.nearbyManager = new NearbyManager();
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetFriendsFindNearby5(this));
    }

    private final void acceptFriendRequest(long userId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().addRelationship("Nearby - Accept Friend Request", userId, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null), false, 1, null), this, null, 2, null), (Class<?>) WidgetFriendsFindNearby.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = widgetFriendsFindNearby.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        return widgetFriendsAddUserAdapter;
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Uninitialized) {
            TextView textView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nearbyFriendsSearchingTitle");
            textView.setText(getString(R.string.add_friend_nearby_title));
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nearbyFriendsSearchingBody");
            textView2.setText(getString(R.string.add_friend_nearby_body));
            TextView textView3 = getBinding().e;
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.nearbyFriendsSearchingBody");
            textView3.setTextColor(ColorCompat.getThemedColor(textView4, R.attr.colorHeaderSecondary));
            MaterialButton materialButton = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.nearbyFriendsEnable");
            materialButton.setVisibility(0);
            RecyclerView recyclerView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
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
        if (model instanceof Model.Error) {
            TextView textView5 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.nearbyFriendsSearchingTitle");
            textView5.setText(getString(R.string.add_friend_nearby_title));
            TextView textView6 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.nearbyFriendsSearchingBody");
            textView6.setText(getErrorMessage(((Model.Error) model).getErrorCode()));
            TextView textView7 = getBinding().e;
            TextView textView8 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.nearbyFriendsSearchingBody");
            textView7.setTextColor(ColorCompat.getColor(textView8, R.color.status_red_500));
            MaterialButton materialButton2 = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.nearbyFriendsEnable");
            materialButton2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.nearbyFriendsRecycler");
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
        if (model instanceof Model.Empty) {
            TextView textView9 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView9, "binding.nearbyFriendsSearchingTitle");
            textView9.setText(getString(R.string.add_friend_nearby_title));
            TextView textView10 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView10, "binding.nearbyFriendsSearchingBody");
            textView10.setText(getString(R.string.add_friend_nearby_body));
            TextView textView11 = getBinding().e;
            TextView textView12 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView12, "binding.nearbyFriendsSearchingBody");
            textView11.setTextColor(ColorCompat.getThemedColor(textView12, R.attr.colorHeaderSecondary));
            MaterialButton materialButton3 = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.nearbyFriendsEnable");
            materialButton3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.nearbyFriendsRecycler");
            recyclerView3.setVisibility(8);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                return;
            }
            getBinding().f.b();
            return;
        }
        if (model instanceof Model.NearbyUsers) {
            TextView textView13 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView13, "binding.nearbyFriendsSearchingTitle");
            textView13.setText(getString(R.string.add_friend_nearby_found_title));
            TextView textView14 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView14, "binding.nearbyFriendsSearchingBody");
            textView14.setText(getString(R.string.add_friend_nearby_found_body));
            TextView textView15 = getBinding().e;
            TextView textView16 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView16, "binding.nearbyFriendsSearchingBody");
            textView15.setTextColor(ColorCompat.getThemedColor(textView16, R.attr.colorHeaderSecondary));
            MaterialButton materialButton4 = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.nearbyFriendsEnable");
            materialButton4.setVisibility(8);
            WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
            if (widgetFriendsAddUserAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
            }
            widgetFriendsAddUserAdapter.setData(((Model.NearbyUsers) model).getItems());
            RecyclerView recyclerView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.nearbyFriendsRecycler");
            recyclerView4.setVisibility(0);
        }
    }

    private final void declineFriendRequest(long userId, boolean incomingFriendRequest) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeRelationship("Nearby - Remove Friend Request", userId), false, 1, null), this, null, 2, null), (Class<?>) WidgetFriendsFindNearby.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(incomingFriendRequest ? R.string.friend_request_ignored : R.string.friend_request_cancelled));
    }

    private final void enableScanning() {
        if (this.meUserId == null) {
            updateMeUserIdAndInitNearbyManager();
        }
        if (this.meUserId != null) {
            NearbyManager nearbyManager = this.nearbyManager;
            FragmentActivity fragmentActivityE = e();
            Objects.requireNonNull(fragmentActivityE, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            nearbyManager.buildClientAndPublish(fragmentActivityE);
        }
    }

    private final WidgetFriendsNearbyBinding getBinding() {
        return (WidgetFriendsNearbyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getErrorMessage(Integer resultCode) {
        if (resultCode != null && resultCode.intValue() == 99) {
            Context context = getContext();
            if (context != null) {
                return context.getString(R.string.add_friend_nearby_connection_error);
            }
            return null;
        }
        if (resultCode != null && resultCode.intValue() == 98) {
            Context context2 = getContext();
            if (context2 != null) {
                return context2.getString(R.string.add_friend_nearby_stopped);
            }
            return null;
        }
        Context context3 = getContext();
        if (context3 != null) {
            return context3.getString(R.string.add_friend_nearby_generic_error);
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
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Nearby - Add Friend Suggestion", username, discriminator, captchaPayload), this, null, 2, null).k(o.h(new Action1<Void>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.sendFriendRequest.1
            @Override // rx.functions.Action1
            public final void call(Void r7) {
                Context context = WidgetFriendsFindNearby.this.getContext();
                Context context2 = WidgetFriendsFindNearby.this.getContext();
                AppToast.h(context, context2 != null ? FormatUtils.b(context2, R.string.add_friend_confirmation, new Object[]{username}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null, 0, null, 12);
            }
        }, getAppActivity(), new Action1<Error>() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.sendFriendRequest.2

            /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ Error $error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(Error error) {
                    super(0);
                    this.$error = error;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Error error = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error, "error");
                    if (WidgetCaptcha4.isCaptchaError(error)) {
                        WidgetFriendsFindNearby widgetFriendsFindNearby = WidgetFriendsFindNearby.this;
                        Error error2 = this.$error;
                        Intrinsics3.checkNotNullExpressionValue(error2, "error");
                        widgetFriendsFindNearby.launchCaptchaFlow(error2);
                        return;
                    }
                    RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                    Context context = WidgetFriendsFindNearby.this.getContext();
                    Error error3 = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error3, "error");
                    Error.Response response = error3.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                    AppToast.h(WidgetFriendsFindNearby.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), username + MentionUtils.CHANNELS_CHAR + UserUtils.INSTANCE.padDiscriminator(discriminator)), 0, null, 12);
                }
            }

            @Override // rx.functions.Action1
            public final void call(Error error) {
                RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        updateMeUserIdAndInitNearbyManager();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = (WidgetFriendsAddUserAdapter) companion.configure(new WidgetFriendsAddUserAdapter(recyclerView));
        this.resultsAdapter = widgetFriendsAddUserAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter.setSendHandler(new AnonymousClass1());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter2 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter2.setAcceptHandler(new AnonymousClass2());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter3 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter3.setDeclineHandler(new AnonymousClass3());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter4 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter4.setOnItemClick(new AnonymousClass4());
        getBinding().f2399b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetFriendsFindNearby.this.enableScanning();
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsFindNearby.onViewBound.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view2, "it", "it.context"), AppHelpDesk.a.a(360014894392L, null), false, false, null, 28, null);
            }
        });
        getBinding().f.c(R.raw.anim_friends_add_nearby_looking, DimenUtils.dpToPixels(200), DimenUtils.dpToPixels(200));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<R> observableG = companion.getUserRelationships().observeForType(4).G(j.j);
        Observable<R> observableG2 = companion.getUserRelationships().observeForType(3).G(j.k);
        WidgetFriendsAddUserRequestsModel2 widgetFriendsAddUserRequestsModel2 = WidgetFriendsAddUserRequestsModel2.j;
        Object widgetFriendsAddUserRequestsModel3 = widgetFriendsAddUserRequestsModel2;
        if (widgetFriendsAddUserRequestsModel2 != null) {
            widgetFriendsAddUserRequestsModel3 = new WidgetFriendsAddUserRequestsModel3(widgetFriendsAddUserRequestsModel2);
        }
        Observable observableJ = Observable.j(observableG, observableG2, (Func2) widgetFriendsAddUserRequestsModel3);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…erRequestsModel\n        )");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.ui$default(observableR, this, null, 2, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
        Observable<Model> observable = ModelProvider.INSTANCE.get(this.nearbyManager.getState());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observable, this, widgetFriendsAddUserAdapter), (Class<?>) WidgetFriendsFindNearby.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
