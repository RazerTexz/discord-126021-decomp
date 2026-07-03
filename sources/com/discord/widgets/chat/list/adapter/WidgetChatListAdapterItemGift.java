package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
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
import com.discord.utilities.gifting.GiftStyleKt;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.PremiumUtils;
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
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p009a.p011a0.C0805c;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

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
            return C1643a.m877t("https://discord.com/store/skus/", skuId);
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
                return C12238m.areEqual(this.gifterUserId, invalid.gifterUserId) && this.meId == invalid.meId;
            }

            public final Long getGifterUserId() {
                return this.gifterUserId;
            }

            public final long getMeId() {
                return this.meId;
            }

            public int hashCode() {
                Long l = this.gifterUserId;
                return C0002b.m3a(this.meId) + ((l != null ? l.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Invalid(gifterUserId=");
                sbM833U.append(this.gifterUserId);
                sbM833U.append(", meId=");
                return C1643a.m815C(sbM833U, this.meId, ")");
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
                C12238m.checkNotNullParameter(modelGift, "gift");
                C12238m.checkNotNullParameter(meUser, "meUser");
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
                C12238m.checkNotNullParameter(gift, "gift");
                C12238m.checkNotNullParameter(meUser, "meUser");
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
                return C12238m.areEqual(this.gift, resolved.gift) && C12238m.areEqual(this.meUser, resolved.meUser) && this.inLibrary == resolved.inLibrary && this.redeeming == resolved.redeeming;
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
                StringBuilder sbM833U = C1643a.m833U("Resolved(gift=");
                sbM833U.append(this.gift);
                sbM833U.append(", meUser=");
                sbM833U.append(this.meUser);
                sbM833U.append(", inLibrary=");
                sbM833U.append(this.inLibrary);
                sbM833U.append(", redeeming=");
                return C1643a.m827O(sbM833U, this.redeeming, ")");
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
            Observable<Model> observableM11076j = Observable.m11076j(new C12721k(Long.valueOf(item.getUserId())), StoreStream.INSTANCE.getUsers().observeMeId(), new Func2<Long, Long, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1
                @Override // p658rx.functions.Func2
                public final WidgetChatListAdapterItemGift.Model call(Long l, Long l2) {
                    C12238m.checkNotNullExpressionValue(l2, "meId");
                    return new WidgetChatListAdapterItemGift.Model.Invalid(l, l2.longValue());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…lid(authorUserId, meId) }");
            return observableM11076j;
        }

        private final Observable<Model> getResolvedGiftModel(final ModelGift gift, final boolean redeeming) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model> observableM11076j = Observable.m11076j(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getLibrary().observeApplications(), new Func2<MeUser, Map<Long, ? extends ModelLibraryApplication>, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getResolvedGiftModel$1
                @Override // p658rx.functions.Func2
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
                        C12238m.checkNotNullExpressionValue(meUser, "me");
                        invalid = new WidgetChatListAdapterItemGift.Model.Resolved(modelGift, meUser, map != null && map.containsKey(Long.valueOf(gift.getSkuId())), redeeming);
                    }
                    return invalid;
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest… me.id)\n        }\n      }");
            return observableM11076j;
        }

        public static /* synthetic */ Observable getResolvedGiftModel$default(ModelProvider modelProvider, ModelGift modelGift, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return modelProvider.getResolvedGiftModel(modelGift, z2);
        }

        public final Observable<Model> get(final GiftEntry item) {
            C12238m.checkNotNullParameter(item, "item");
            Observable observableM11099Y = StoreStream.INSTANCE.getGifting().requestGift(item.getGiftCode()).m11099Y(new InterfaceC12589b<StoreGifting.GiftState, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$get$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetChatListAdapterItemGift.Model> call(StoreGifting.GiftState giftState) {
                    if ((giftState instanceof StoreGifting.GiftState.Loading) || (giftState instanceof StoreGifting.GiftState.LoadFailed)) {
                        return new C12721k(WidgetChatListAdapterItemGift.Model.Loading.INSTANCE);
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
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
            return observableM11099Y;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class C80671 extends AbstractC12240o implements Function1<ImageRequestBuilder, Unit> {
        public static final C80671 INSTANCE = new C80671();

        public C80671() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            C12238m.checkNotNullParameter(imageRequestBuilder, "it");
            imageRequestBuilder.f19623l = WidgetChatListAdapterItemGift.SPLASH_IMAGE_POSTPROCESSOR;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final /* synthetic */ class C80711 extends C12236k implements Function1<Model, Unit> {
        public C80711(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
            super(1, widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemGift) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class C80722 extends AbstractC12240o implements Function1<Error, Unit> {
        public C80722() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGift.this.configureInvalidUI(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
    public static final class C80733 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C80733() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGift.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGift(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_gift, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.barrier;
        Barrier barrier = (Barrier) view.findViewById(C5419R.id.barrier);
        if (barrier != null) {
            i = C5419R.id.buttonsContainer;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.buttonsContainer);
            if (frameLayout != null) {
                i = C5419R.id.item_gift_accept_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.item_gift_accept_button);
                if (materialButton != null) {
                    i = C5419R.id.item_gift_cannot_claim_button;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.item_gift_cannot_claim_button);
                    if (materialButton2 != null) {
                        i = C5419R.id.item_gift_details;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.item_gift_details);
                        if (linearLayout != null) {
                            i = C5419R.id.item_gift_expires;
                            TextView textView = (TextView) view.findViewById(C5419R.id.item_gift_expires);
                            if (textView != null) {
                                i = C5419R.id.item_gift_header;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.item_gift_header);
                                if (textView2 != null) {
                                    i = C5419R.id.item_gift_image;
                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.item_gift_image);
                                    if (simpleDraweeView != null) {
                                        i = C5419R.id.item_gift_image_background;
                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.item_gift_image_background);
                                        if (simpleDraweeView2 != null) {
                                            i = C5419R.id.item_gift_loading_button_placeholder;
                                            View viewFindViewById = view.findViewById(C5419R.id.item_gift_loading_button_placeholder);
                                            if (viewFindViewById != null) {
                                                i = C5419R.id.item_gift_name;
                                                TextView textView3 = (TextView) view.findViewById(C5419R.id.item_gift_name);
                                                if (textView3 != null) {
                                                    i = C5419R.id.item_gift_open_button;
                                                    MaterialButton materialButton3 = (MaterialButton) view.findViewById(C5419R.id.item_gift_open_button);
                                                    if (materialButton3 != null) {
                                                        i = C5419R.id.item_gift_subtext;
                                                        TextView textView4 = (TextView) view.findViewById(C5419R.id.item_gift_subtext);
                                                        if (textView4 != null) {
                                                            i = C5419R.id.item_gift_verify_button;
                                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(C5419R.id.item_gift_verify_button);
                                                            if (materialButton4 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                WidgetChatListAdapterItemGiftBinding widgetChatListAdapterItemGiftBinding = new WidgetChatListAdapterItemGiftBinding(constraintLayout, barrier, frameLayout, materialButton, materialButton2, linearLayout, textView, textView2, simpleDraweeView, simpleDraweeView2, viewFindViewById, textView3, materialButton3, textView4, materialButton4, constraintLayout);
                                                                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemGiftBinding, "WidgetChatListAdapterIte…iftBinding.bind(itemView)");
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
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        return giftEntry;
    }

    private final void configureInvalidUI(Model.Invalid model) {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        boolean zAreEqual = C12238m.areEqual(model != null ? model.getGifterUserId() : null, model != null ? Long.valueOf(model.getMeId()) : null);
        SimpleDraweeView simpleDraweeView = this.binding.f16216h;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView = this.binding.f16214f;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        C1107b.m223o(textView, zAreEqual ? context.getString(C5419R.string.gift_embed_invalid_title_self) : context.getString(C5419R.string.gift_embed_invalid_title_other), new Object[0], null, 4);
        TextView textView2 = this.binding.f16218j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        C1107b.m221m(textView2, C5419R.string.gift_embed_invalid, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        this.binding.f16218j.setTextColor(ColorCompat.getColor(context, C5419R.color.status_red_500));
        this.binding.f16218j.setBackgroundResource(0);
        C12238m.checkNotNullExpressionValue(context, "context");
        this.binding.f16215g.setImageResource(DrawableCompat.getThemedDrawableRes(context, C5419R.attr.img_poop, C5419R.drawable.img_poop_dark));
        TextView textView3 = this.binding.f16220l;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.f16213e;
        C12238m.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.f16211c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.f16212d;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.f16217i;
        C12238m.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
        view2.setVisibility(8);
        this.itemView.setOnClickListener(null);
    }

    private final void configureLoadingUI() {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        TextView textView = this.binding.f16214f;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        C1107b.m221m(textView, C5419R.string.gift_embed_resolving, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = this.binding.f16218j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        textView2.setText((CharSequence) null);
        this.binding.f16218j.setTextColor(ColorCompat.getThemedColor(context, C5419R.attr.primary_100));
        this.binding.f16218j.setBackgroundResource(C5419R.drawable.drawable_empty_text_placeholder_dark);
        this.binding.f16215g.setActualImageResource(C5419R.drawable.drawable_empty_text_placeholder_dark);
        SimpleDraweeView simpleDraweeView = this.binding.f16216h;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView3 = this.binding.f16220l;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.f16213e;
        C12238m.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.f16211c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.f16212d;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.f16217i;
        C12238m.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
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
        C12238m.checkNotNullExpressionValue(view, "itemView");
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
        C12238m.checkNotNullExpressionValue(view2, "itemView");
        String giftSplashUrl = iconUtils.getGiftSplashUrl(applicationId, splash, Integer.valueOf(view2.getWidth()));
        if (model.getGift().isAnyNitroGift()) {
            SimpleDraweeView simpleDraweeView = this.binding.f16216h;
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            ModelGift gift = model.getGift();
            C12238m.checkNotNullExpressionValue(context, "context");
            simpleDraweeView.setActualImageResource(premiumUtils.getNitroGiftBackground(gift, context));
            SimpleDraweeView simpleDraweeView2 = this.binding.f16216h;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemGiftImageBackground");
            simpleDraweeView2.setVisibility(0);
        } else if (giftSplashUrl != null) {
            SimpleDraweeView simpleDraweeView3 = this.binding.f16216h;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemGiftImageBackground");
            MGImages.setImage$default(simpleDraweeView3, giftSplashUrl, 0, 0, false, C80671.INSTANCE, null, 92, null);
            SimpleDraweeView simpleDraweeView4 = this.binding.f16216h;
            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemGiftImageBackground");
            simpleDraweeView4.setVisibility(0);
        } else {
            SimpleDraweeView simpleDraweeView5 = this.binding.f16216h;
            C12238m.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemGiftImageBackground");
            simpleDraweeView5.setVisibility(8);
        }
        TextView textView = this.binding.f16214f;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        C1107b.m223o(textView, z2 ? context.getString(C5419R.string.gift_embed_title_self) : context.getString(C5419R.string.gift_embed_title), new Object[0], null, 4);
        TextView textView2 = this.binding.f16218j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        ModelStoreListing storeListing3 = model.getGift().getStoreListing();
        textView2.setText((storeListing3 == null || (sku3 = storeListing3.getSku()) == null) ? null : sku3.getName());
        this.binding.f16218j.setTextColor(ColorCompat.getThemedColor(context, C5419R.attr.primary_100));
        this.binding.f16218j.setBackgroundResource(0);
        TextView textView3 = this.binding.f16213e;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemGiftExpires");
        textView3.setVisibility(model.getGift().getExpiresAt() != null ? 0 : 8);
        if (model.getGift().getExpiresAt() != null) {
            TextView textView4 = this.binding.f16213e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
            C12238m.checkNotNullExpressionValue(context, "context");
            textView4.setText(C1107b.m210b(context, C5419R.string.gift_embed_expiration, new Object[]{GiftingUtils.INSTANCE.getTimeString(model.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context)}, (4 & 4) != 0 ? C1107b.b.f1491j : null));
        }
        if (model.getGift().isAnyNitroGift()) {
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView6 = this.binding.f16215g;
            C12238m.checkNotNullExpressionValue(simpleDraweeView6, "binding.itemGiftImage");
            MGImages.setImage$default(mGImages, simpleDraweeView6, PremiumUtils.INSTANCE.getNitroGiftIcon(model.getGift()), (MGImages.ChangeDetector) null, 4, (Object) null);
        } else {
            ModelStoreListing storeListing4 = model.getGift().getStoreListing();
            if (storeListing4 == null || (sku = storeListing4.getSku()) == null || (application = sku.getApplication()) == null || (icon = application.getIcon()) == null) {
                applicationIcon$default = null;
            } else {
                ModelStoreListing storeListing5 = model.getGift().getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing5 == null || (sku2 = storeListing5.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            this.binding.f16215g.setImageURI(applicationIcon$default);
        }
        if (!model.getMeUser().isVerified()) {
            String string2 = context.getString(C5419R.string.gift_code_auth_help_text_verification_required);
            C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…xt_verification_required)");
            string = C12103t.replace$default(C12103t.replace$default(C12103t.replace$default(string2, "(onClick)", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else if (zIsClaimedByMe) {
            string = context.getString(C5419R.string.gift_embed_body_claimed_self_mobile);
        } else if (model.getInLibrary()) {
            C12238m.checkNotNullExpressionValue(context, "context");
            string = C12103t.replace$default(C12103t.replace$default(C12103t.replace$default(C1107b.m210b(context, C5419R.string.gift_code_auth_help_text_owned, new Object[]{""}, (4 & 4) != 0 ? C1107b.b.f1491j : null).toString(), "()", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else {
            string = z3 ? context.getString(C5419R.string.gift_code_auth_help_text_claimed) : null;
        }
        TextView textView5 = this.binding.f16220l;
        C12238m.checkNotNullExpressionValue(textView5, "binding.itemGiftSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView5, string);
        if (z4) {
            materialButton = GiftStyleKt.hasCustomStyle(model.getGift()) ? this.binding.f16219k : this.binding.f16211c;
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    C0805c.INSTANCE.m107a(model.getGift().getCode(), "Embed", WidgetChatListAdapterItemGift.access$getItem$p(this.this$0).getChannelId());
                }
            });
        } else if (model.getMeUser().isVerified()) {
            materialButton = this.binding.f16212d;
            boolean redeeming = model.getRedeeming();
            int i = C5419R.string.gift_embed_button_claimed;
            if (redeeming) {
                i = C5419R.string.gift_embed_button_claiming;
            } else if (!zIsClaimedByMe && model.getInLibrary()) {
                i = C5419R.string.gift_embed_button_owned;
            }
            C1107b.m221m(materialButton, i, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            materialButton = this.binding.f16221m;
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
                    C12238m.checkNotNullExpressionValue(view3, "it");
                    Context context2 = view3.getContext();
                    C12238m.checkNotNullExpressionValue(context2, "it.context");
                    WidgetSettingsAccount.Companion.launch$default(companion, context2, false, null, 6, null);
                }
            });
        }
        C12238m.checkNotNullExpressionValue(materialButton, "if (canAccept) {\n      i…}\n        )\n      }\n    }");
        FrameLayout frameLayout = this.binding.f16210b;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.buttonsContainer");
        for (View view3 : ViewGroupKt.getChildren(frameLayout)) {
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
                    C12238m.checkNotNullExpressionValue(view4, "it");
                    Context context2 = view4.getContext();
                    C12238m.checkNotNullExpressionValue(context2, "it.context");
                    WidgetSettingsPremium.Companion.launch$default(companion, context2, null, null, 6, null);
                }
            });
        } else {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift.configureResolvedUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context2 = context;
                    C12238m.checkNotNullExpressionValue(context2, "context");
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
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GiftEntry giftEntry = (GiftEntry) data;
        this.item = giftEntry;
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        if (giftEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(modelProvider.get(giftEntry)), (Class<?>) WidgetChatListAdapterItemGift.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C80733()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C80722()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80711(this));
    }
}
