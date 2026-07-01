package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import b.a.a.a0.WidgetGiftAcceptDialog;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatListAdapterItemGiftBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelLibraryApplication;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.fresco.GrayscalePostprocessor;
import com.discord.utilities.gifting.GiftStyle3;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GiftEntry;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.button.MaterialButton;
import d0.g0.StringsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift extends WidgetChatListItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GrayscalePostprocessor SPLASH_IMAGE_POSTPROCESSOR = new GrayscalePostprocessor();
    private final WidgetChatListAdapterItemGiftBinding binding;
    private GiftEntry item;
    private Subscription subscription;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String getDiscordStoreURL(long skuId) {
            return outline.t("https://discord.com/store/skus/", skuId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static abstract class Model {

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
        public static final /* data */ class Invalid extends Model {
            private final Long gifterUserId;
            private final long meId;

            public Invalid(Long l, long j) {
                super(null);
                this.gifterUserId = l;
                this.meId = j;
            }

            public static /* synthetic */ Invalid copy$default(Invalid invalid, Long l, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = invalid.gifterUserId;
                }
                if ((i & 2) != 0) {
                    j = invalid.meId;
                }
                return invalid.copy(l, j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Long getGifterUserId() {
                return this.gifterUserId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getMeId() {
                return this.meId;
            }

            public final Invalid copy(Long gifterUserId, long meId) {
                return new Invalid(gifterUserId, meId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invalid)) {
                    return false;
                }
                Invalid invalid = (Invalid) other;
                return Intrinsics3.areEqual(this.gifterUserId, invalid.gifterUserId) && this.meId == invalid.meId;
            }

            public final Long getGifterUserId() {
                return this.gifterUserId;
            }

            public final long getMeId() {
                return this.meId;
            }

            public int hashCode() {
                Long l = this.gifterUserId;
                return b.a(this.meId) + ((l != null ? l.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Invalid(gifterUserId=");
                sbU.append(this.gifterUserId);
                sbU.append(", meId=");
                return outline.C(sbU, this.meId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
        public static final /* data */ class Resolved extends Model {
            private final ModelGift gift;
            private final boolean inLibrary;
            private final MeUser meUser;
            private final boolean redeeming;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGift modelGift, MeUser meUser, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGift, "gift");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                this.gift = modelGift;
                this.meUser = meUser;
                this.inLibrary = z2;
                this.redeeming = z3;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGift modelGift, MeUser meUser, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = resolved.gift;
                }
                if ((i & 2) != 0) {
                    meUser = resolved.meUser;
                }
                if ((i & 4) != 0) {
                    z2 = resolved.inLibrary;
                }
                if ((i & 8) != 0) {
                    z3 = resolved.redeeming;
                }
                return resolved.copy(modelGift, meUser, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGift getGift() {
                return this.gift;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getInLibrary() {
                return this.inLibrary;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getRedeeming() {
                return this.redeeming;
            }

            public final Resolved copy(ModelGift gift, MeUser meUser, boolean inLibrary, boolean redeeming) {
                Intrinsics3.checkNotNullParameter(gift, "gift");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                return new Resolved(gift, meUser, inLibrary, redeeming);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Resolved)) {
                    return false;
                }
                Resolved resolved = (Resolved) other;
                return Intrinsics3.areEqual(this.gift, resolved.gift) && Intrinsics3.areEqual(this.meUser, resolved.meUser) && this.inLibrary == resolved.inLibrary && this.redeeming == resolved.redeeming;
            }

            public final ModelGift getGift() {
                return this.gift;
            }

            public final boolean getInLibrary() {
                return this.inLibrary;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final boolean getRedeeming() {
                return this.redeeming;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                ModelGift modelGift = this.gift;
                int iHashCode = (modelGift != null ? modelGift.hashCode() : 0) * 31;
                MeUser meUser = this.meUser;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                boolean z2 = this.inLibrary;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean z3 = this.redeeming;
                return i + (z3 ? 1 : z3);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(gift=");
                sbU.append(this.gift);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(", inLibrary=");
                sbU.append(this.inLibrary);
                sbU.append(", redeeming=");
                return outline.O(sbU, this.redeeming, ")");
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        private final Observable<Model> getInvalidGift(GiftEntry item) {
            Observable<Model> observableJ = Observable.j(new ScalarSynchronousObservable(Long.valueOf(item.getUserId())), StoreStream.INSTANCE.getUsers().observeMeId(), new Func2<Long, Long, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1
                @Override // rx.functions.Func2
                public final WidgetChatListAdapterItemGift.Model call(Long l, Long l2) {
                    Intrinsics3.checkNotNullExpressionValue(l2, "meId");
                    return new WidgetChatListAdapterItemGift.Model.Invalid(l, l2.longValue());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…lid(authorUserId, meId) }");
            return observableJ;
        }

        private final Observable<Model> getResolvedGiftModel(final ModelGift gift, final boolean redeeming) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model> observableJ = Observable.j(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getLibrary().observeApplications(), new Func2<MeUser, Map<Long, ? extends ModelLibraryApplication>, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getResolvedGiftModel$1
                @Override // rx.functions.Func2
                public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGift.Model call(MeUser meUser, Map<Long, ? extends ModelLibraryApplication> map) {
                    return call2(meUser, (Map<Long, ModelLibraryApplication>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChatListAdapterItemGift.Model call2(MeUser meUser, Map<Long, ModelLibraryApplication> map) {
                    WidgetChatListAdapterItemGift.Model invalid;
                    if (gift.isExpired(ClockFactory.get().currentTimeMillis())) {
                        User user = gift.getUser();
                        invalid = new WidgetChatListAdapterItemGift.Model.Invalid(user != null ? Long.valueOf(user.getId()) : null, meUser.getId());
                    } else {
                        ModelGift modelGift = gift;
                        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                        invalid = new WidgetChatListAdapterItemGift.Model.Resolved(modelGift, meUser, map != null && map.containsKey(Long.valueOf(gift.getSkuId())), redeeming);
                    }
                    return invalid;
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… me.id)\n        }\n      }");
            return observableJ;
        }

        public static /* synthetic */ Observable getResolvedGiftModel$default(ModelProvider modelProvider, ModelGift modelGift, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return modelProvider.getResolvedGiftModel(modelGift, z2);
        }

        public final Observable<Model> get(final GiftEntry item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            Observable observableY = StoreStream.INSTANCE.getGifting().requestGift(item.getGiftCode()).Y(new Func1<StoreGifting.GiftState, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$get$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChatListAdapterItemGift.Model> call(StoreGifting.GiftState giftState) {
                    if ((giftState instanceof StoreGifting.GiftState.Loading) || (giftState instanceof StoreGifting.GiftState.LoadFailed)) {
                        return new ScalarSynchronousObservable(WidgetChatListAdapterItemGift.Model.Loading.INSTANCE);
                    }
                    if (giftState instanceof StoreGifting.GiftState.Revoking) {
                        return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Revoking) giftState).getGift(), false, 2, null);
                    }
                    if (giftState instanceof StoreGifting.GiftState.Resolved) {
                        return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Resolved) giftState).getGift(), false, 2, null);
                    }
                    if (giftState instanceof StoreGifting.GiftState.Redeeming) {
                        return WidgetChatListAdapterItemGift.ModelProvider.INSTANCE.getResolvedGiftModel(((StoreGifting.GiftState.Redeeming) giftState).getGift(), true);
                    }
                    if (giftState instanceof StoreGifting.GiftState.RedeemedFailed) {
                        return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.RedeemedFailed) giftState).getGift(), false, 2, null);
                    }
                    if (giftState instanceof StoreGifting.GiftState.Invalid) {
                        return WidgetChatListAdapterItemGift.ModelProvider.INSTANCE.getInvalidGift(item);
                    }
                    throw new NoWhenBranchMatchedException();
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
            return observableY;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            Intrinsics3.checkNotNullParameter(imageRequestBuilder, "it");
            imageRequestBuilder.l = WidgetChatListAdapterItemGift.SPLASH_IMAGE_POSTPROCESSOR;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
            super(1, widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemGift) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGift.this.configureInvalidUI(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGift.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGift(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_gift, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.barrier;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier);
        if (barrier != null) {
            i = R.id.buttonsContainer;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.buttonsContainer);
            if (frameLayout != null) {
                i = R.id.item_gift_accept_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_gift_accept_button);
                if (materialButton != null) {
                    i = R.id.item_gift_cannot_claim_button;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.item_gift_cannot_claim_button);
                    if (materialButton2 != null) {
                        i = R.id.item_gift_details;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.item_gift_details);
                        if (linearLayout != null) {
                            i = R.id.item_gift_expires;
                            TextView textView = (TextView) view.findViewById(R.id.item_gift_expires);
                            if (textView != null) {
                                i = R.id.item_gift_header;
                                TextView textView2 = (TextView) view.findViewById(R.id.item_gift_header);
                                if (textView2 != null) {
                                    i = R.id.item_gift_image;
                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_gift_image);
                                    if (simpleDraweeView != null) {
                                        i = R.id.item_gift_image_background;
                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.item_gift_image_background);
                                        if (simpleDraweeView2 != null) {
                                            i = R.id.item_gift_loading_button_placeholder;
                                            View viewFindViewById = view.findViewById(R.id.item_gift_loading_button_placeholder);
                                            if (viewFindViewById != null) {
                                                i = R.id.item_gift_name;
                                                TextView textView3 = (TextView) view.findViewById(R.id.item_gift_name);
                                                if (textView3 != null) {
                                                    i = R.id.item_gift_open_button;
                                                    MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.item_gift_open_button);
                                                    if (materialButton3 != null) {
                                                        i = R.id.item_gift_subtext;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.item_gift_subtext);
                                                        if (textView4 != null) {
                                                            i = R.id.item_gift_verify_button;
                                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R.id.item_gift_verify_button);
                                                            if (materialButton4 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                WidgetChatListAdapterItemGiftBinding widgetChatListAdapterItemGiftBinding = new WidgetChatListAdapterItemGiftBinding(constraintLayout, barrier, frameLayout, materialButton, materialButton2, linearLayout, textView, textView2, simpleDraweeView, simpleDraweeView2, viewFindViewById, textView3, materialButton3, textView4, materialButton4, constraintLayout);
                                                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGiftBinding, "WidgetChatListAdapterIte…iftBinding.bind(itemView)");
                                                                this.binding = widgetChatListAdapterItemGiftBinding;
                                                                return;
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ GiftEntry access$getItem$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
        GiftEntry giftEntry = widgetChatListAdapterItemGift.item;
        if (giftEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        return giftEntry;
    }

    private final void configureInvalidUI(Model.Invalid model) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        boolean zAreEqual = Intrinsics3.areEqual(model != null ? model.getGifterUserId() : null, model != null ? Long.valueOf(model.getMeId()) : null);
        SimpleDraweeView simpleDraweeView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        FormatUtils.o(textView, zAreEqual ? context.getString(R.string.gift_embed_invalid_title_self) : context.getString(R.string.gift_embed_invalid_title_other), new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        FormatUtils.m(textView2, R.string.gift_embed_invalid, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        this.binding.j.setTextColor(ColorCompat.getColor(context, R.color.status_red_500));
        this.binding.j.setBackgroundResource(0);
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        this.binding.g.setImageResource(DrawableCompat.getThemedDrawableRes(context, R.attr.img_poop, R.drawable.img_poop_dark));
        TextView textView3 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
        view2.setVisibility(8);
        this.itemView.setOnClickListener(null);
    }

    private final void configureLoadingUI() {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        FormatUtils.m(textView, R.string.gift_embed_resolving, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        textView2.setText((CharSequence) null);
        this.binding.j.setTextColor(ColorCompat.getThemedColor(context, R.attr.primary_100));
        this.binding.j.setBackgroundResource(R.drawable.drawable_empty_text_placeholder_dark);
        this.binding.g.setActualImageResource(R.drawable.drawable_empty_text_placeholder_dark);
        SimpleDraweeView simpleDraweeView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView3 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
        view2.setVisibility(0);
        this.itemView.setOnClickListener(null);
    }

    private final void configureResolvedUI(final Model.Resolved model) {
        String applicationIcon$default;
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        String string;
        MaterialButton materialButton;
        ModelSku sku3;
        ModelSku sku4;
        Application application2;
        ModelSku sku5;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        final Context context = view.getContext();
        User user = model.getGift().getUser();
        boolean z2 = user != null && user.getId() == model.getMeUser().getId();
        boolean zIsClaimedByMe = model.getGift().isClaimedByMe();
        boolean z3 = model.getGift().getUses() == model.getGift().getMaxUses();
        boolean z4 = (model.getInLibrary() || z3 || model.getRedeeming() || !model.getMeUser().isVerified() || zIsClaimedByMe) ? false : true;
        IconUtils iconUtils = IconUtils.INSTANCE;
        ModelStoreListing storeListing = model.getGift().getStoreListing();
        long applicationId = (storeListing == null || (sku5 = storeListing.getSku()) == null) ? 0L : sku5.getApplicationId();
        ModelStoreListing storeListing2 = model.getGift().getStoreListing();
        String splash = (storeListing2 == null || (sku4 = storeListing2.getSku()) == null || (application2 = sku4.getApplication()) == null) ? null : application2.getSplash();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        String giftSplashUrl = iconUtils.getGiftSplashUrl(applicationId, splash, Integer.valueOf(view2.getWidth()));
        if (model.getGift().isAnyNitroGift()) {
            SimpleDraweeView simpleDraweeView = this.binding.h;
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            ModelGift gift = model.getGift();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            simpleDraweeView.setActualImageResource(premiumUtils.getNitroGiftBackground(gift, context));
            SimpleDraweeView simpleDraweeView2 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemGiftImageBackground");
            simpleDraweeView2.setVisibility(0);
        } else if (giftSplashUrl != null) {
            SimpleDraweeView simpleDraweeView3 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemGiftImageBackground");
            MGImages.setImage$default(simpleDraweeView3, giftSplashUrl, 0, 0, false, AnonymousClass1.INSTANCE, null, 92, null);
            SimpleDraweeView simpleDraweeView4 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemGiftImageBackground");
            simpleDraweeView4.setVisibility(0);
        } else {
            SimpleDraweeView simpleDraweeView5 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemGiftImageBackground");
            simpleDraweeView5.setVisibility(8);
        }
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        FormatUtils.o(textView, z2 ? context.getString(R.string.gift_embed_title_self) : context.getString(R.string.gift_embed_title), new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        ModelStoreListing storeListing3 = model.getGift().getStoreListing();
        textView2.setText((storeListing3 == null || (sku3 = storeListing3.getSku()) == null) ? null : sku3.getName());
        this.binding.j.setTextColor(ColorCompat.getThemedColor(context, R.attr.primary_100));
        this.binding.j.setBackgroundResource(0);
        TextView textView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGiftExpires");
        textView3.setVisibility(model.getGift().getExpiresAt() != null ? 0 : 8);
        if (model.getGift().getExpiresAt() != null) {
            TextView textView4 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView4.setText(FormatUtils.b(context, R.string.gift_embed_expiration, new Object[]{GiftingUtils.INSTANCE.getTimeString(model.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context)}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        }
        if (model.getGift().isAnyNitroGift()) {
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView6 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.itemGiftImage");
            MGImages.setImage$default(mGImages, simpleDraweeView6, PremiumUtils.INSTANCE.getNitroGiftIcon(model.getGift()), (MGImages.ChangeDetector) null, 4, (Object) null);
        } else {
            ModelStoreListing storeListing4 = model.getGift().getStoreListing();
            if (storeListing4 == null || (sku = storeListing4.getSku()) == null || (application = sku.getApplication()) == null || (icon = application.getIcon()) == null) {
                applicationIcon$default = null;
            } else {
                ModelStoreListing storeListing5 = model.getGift().getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing5 == null || (sku2 = storeListing5.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            this.binding.g.setImageURI(applicationIcon$default);
        }
        if (!model.getMeUser().isVerified()) {
            String string2 = context.getString(R.string.gift_code_auth_help_text_verification_required);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…xt_verification_required)");
            string = StringsJVM.replace$default(StringsJVM.replace$default(StringsJVM.replace$default(string2, "(onClick)", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else if (zIsClaimedByMe) {
            string = context.getString(R.string.gift_embed_body_claimed_self_mobile);
        } else if (model.getInLibrary()) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            string = StringsJVM.replace$default(StringsJVM.replace$default(StringsJVM.replace$default(FormatUtils.b(context, R.string.gift_code_auth_help_text_owned, new Object[]{""}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString(), "()", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else {
            string = z3 ? context.getString(R.string.gift_code_auth_help_text_claimed) : null;
        }
        TextView textView5 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.itemGiftSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView5, string);
        if (z4) {
            materialButton = GiftStyle3.hasCustomStyle(model.getGift()) ? this.binding.k : this.binding.c;
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetGiftAcceptDialog.INSTANCE.a(model.getGift().getCode(), "Embed", WidgetChatListAdapterItemGift.access$getItem$p(this.this$0).getChannelId());
                }
            });
        } else if (model.getMeUser().isVerified()) {
            materialButton = this.binding.d;
            boolean redeeming = model.getRedeeming();
            int i = R.string.gift_embed_button_claimed;
            if (redeeming) {
                i = R.string.gift_embed_button_claiming;
            } else if (!zIsClaimedByMe && model.getInLibrary()) {
                i = R.string.gift_embed_button_owned;
            }
            FormatUtils.m(materialButton, i, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        } else {
            materialButton = this.binding.m;
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(view3, "it");
                    Context context2 = view3.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
                    WidgetSettingsAccount.Companion.launch$default(companion, context2, false, null, 6, null);
                }
            });
        }
        Intrinsics3.checkNotNullExpressionValue(materialButton, "if (canAccept) {\n      i…}\n        )\n      }\n    }");
        FrameLayout frameLayout = this.binding.f2320b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.buttonsContainer");
        for (View view3 : ViewGroup.getChildren(frameLayout)) {
            if (view3 == materialButton) {
                ((MaterialButton) view3).setVisibility(0);
            } else {
                view3.setVisibility(8);
            }
        }
        if (model.getGift().isAnyNitroGift()) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift.configureResolvedUI.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(view4, "it");
                    Context context2 = view4.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
                    WidgetSettingsPremium.Companion.launch$default(companion, context2, null, null, 6, null);
                }
            });
        } else {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift.configureResolvedUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context2 = context;
                    Intrinsics3.checkNotNullExpressionValue(context2, "context");
                    UriHandler.handle$default(uriHandler, context2, WidgetChatListAdapterItemGift.INSTANCE.getDiscordStoreURL(model.getGift().getSkuId()), false, false, null, 28, null);
                }
            });
        }
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            configureLoadingUI();
        } else if (model instanceof Model.Resolved) {
            configureResolvedUI((Model.Resolved) model);
        } else {
            if (!(model instanceof Model.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI((Model.Invalid) model);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GiftEntry giftEntry = (GiftEntry) data;
        this.item = giftEntry;
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        if (giftEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(modelProvider.get(giftEntry)), (Class<?>) WidgetChatListAdapterItemGift.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
