package com.discord.widgets.settings.connections;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsConnectionsAddBinding;
import com.discord.databinding.WidgetSettingsItemAddConnectedAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.playstation.PlaystationExperimentUtilsKt;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsUserConnectionsAdd.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<PlatformItem> {
        private final Function0<Unit> dialogDismissCallback;

        /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
        public static final class ViewHolder extends MGRecyclerViewHolder<Adapter, PlatformItem> {
            private final WidgetSettingsItemAddConnectedAccountBinding binding;
            private final Function0<Unit> dialogDismissCallback;

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    Platform.values();
                    int[] iArr = new int[15];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[Platform.XBOX.ordinal()] = 1;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@LayoutRes int i, Adapter adapter, Function0<Unit> function0) {
                super(i, adapter);
                C12238m.checkNotNullParameter(adapter, "adapter");
                C12238m.checkNotNullParameter(function0, "dialogDismissCallback");
                this.dialogDismissCallback = function0;
                View view = this.itemView;
                int i2 = C5419R.id.add_connected_account_image;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.add_connected_account_image);
                if (imageView != null) {
                    i2 = C5419R.id.add_connected_account_text;
                    TextView textView = (TextView) view.findViewById(C5419R.id.add_connected_account_text);
                    if (textView != null) {
                        WidgetSettingsItemAddConnectedAccountBinding widgetSettingsItemAddConnectedAccountBinding = new WidgetSettingsItemAddConnectedAccountBinding((LinearLayout) view, imageView, textView);
                        C12238m.checkNotNullExpressionValue(widgetSettingsItemAddConnectedAccountBinding, "WidgetSettingsItemAddCon…untBinding.bind(itemView)");
                        this.binding = widgetSettingsItemAddConnectedAccountBinding;
                        return;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            public final Function0<Unit> getDialogDismissCallback() {
                return this.dialogDismissCallback;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final PlatformItem data) {
                C12238m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                TextView textView = this.binding.f17974c;
                C12238m.checkNotNullExpressionValue(textView, "binding.addConnectedAccountText");
                textView.setText(data.getPlatform().getProperName());
                ImageView imageView = this.binding.f17973b;
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                Integer themedPlatformImage = data.getPlatform().getThemedPlatformImage();
                imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(view, themedPlatformImage != null ? themedPlatformImage.intValue() : 0, 0, 2, (Object) null));
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.this$0.getDialogDismissCallback().invoke();
                        if (data.getPlatform().ordinal() == 12) {
                            WidgetSettingsUserConnectionsAddXbox.Companion companion = WidgetSettingsUserConnectionsAddXbox.Companion;
                            C12238m.checkNotNullExpressionValue(view2, "v");
                            Context context = view2.getContext();
                            C12238m.checkNotNullExpressionValue(context, "v.context");
                            companion.launch(context);
                            return;
                        }
                        StoreUserConnections userConnections = StoreStream.INSTANCE.getUserConnections();
                        String platformId = data.getPlatform().getPlatformId();
                        C12238m.checkNotNullExpressionValue(view2, "v");
                        Context context2 = view2.getContext();
                        C12238m.checkNotNullExpressionValue(context2, "v.context");
                        userConnections.authorizeConnection(platformId, context2, Traits.Location.Page.USER_SETTINGS);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, Function0<Unit> function0) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            C12238m.checkNotNullParameter(function0, "dialogDismissCallback");
            this.dialogDismissCallback = function0;
        }

        public final Function0<Unit> getDialogDismissCallback() {
            return this.dialogDismissCallback;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, PlatformItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            return new ViewHolder(C5419R.layout.widget_settings_item_add_connected_account, this, this.dialogDismissCallback);
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            WidgetSettingsUserConnectionsAdd widgetSettingsUserConnectionsAdd = new WidgetSettingsUserConnectionsAdd();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetSettingsUserConnectionsAdd.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
    public static final /* data */ class PlatformItem implements MGRecyclerDataPayload {
        private final String key;
        private final Platform platform;
        private final int type;

        public PlatformItem(Platform platform) {
            C12238m.checkNotNullParameter(platform, "platform");
            this.platform = platform;
            this.key = platform.name();
        }

        public static /* synthetic */ PlatformItem copy$default(PlatformItem platformItem, Platform platform, int i, Object obj) {
            if ((i & 1) != 0) {
                platform = platformItem.platform;
            }
            return platformItem.copy(platform);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Platform getPlatform() {
            return this.platform;
        }

        public final PlatformItem copy(Platform platform) {
            C12238m.checkNotNullParameter(platform, "platform");
            return new PlatformItem(platform);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PlatformItem) && C12238m.areEqual(this.platform, ((PlatformItem) other).platform);
            }
            return true;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Platform getPlatform() {
            return this.platform;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            Platform platform = this.platform;
            if (platform != null) {
                return platform.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PlatformItem(platform=");
            sbM833U.append(this.platform);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
    public static final class C98351 extends AbstractC12240o implements Function0<Unit> {
        public C98351() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Dialog dialog = WidgetSettingsUserConnectionsAdd.this.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public WidgetSettingsUserConnectionsAdd() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsUserConnectionsAdd$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsConnectionsAddBinding getBinding() {
        return (WidgetSettingsConnectionsAddBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_settings_connections_add;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        hideKeyboard(getView());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        boolean zCanSeePlaystationAccountIntegration = PlaystationExperimentUtilsKt.canSeePlaystationAccountIntegration(StoreStream.INSTANCE.getExperiments());
        Platform[] platformArrValues = Platform.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            Platform platform = platformArrValues[i];
            if (platform.getEnabled() && (platform != Platform.PLAYSTATION || zCanSeePlaystationAccountIntegration)) {
                arrayList.add(platform);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new PlatformItem((Platform) it.next()));
        }
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17931b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
        Adapter adapter = (Adapter) companion.configure(new Adapter(recyclerView, new C98351()));
        this.adapter = adapter;
        if (adapter != null) {
            adapter.setData(arrayList2);
        }
    }
}
