package com.discord.widgets.settings.connections;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsConnectionsAddBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.playstation.PlaystationExperimentUtilsKt;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsUserConnectionsAdd.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", 0)};
    public static final WidgetSettingsUserConnectionsAdd$Companion Companion = new WidgetSettingsUserConnectionsAdd$Companion(null);
    private WidgetSettingsUserConnectionsAdd$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsUserConnectionsAdd() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsUserConnectionsAdd$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsConnectionsAddBinding getBinding() {
        return (WidgetSettingsConnectionsAddBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_settings_connections_add;
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
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        boolean zCanSeePlaystationAccountIntegration = PlaystationExperimentUtilsKt.canSeePlaystationAccountIntegration(StoreStream.Companion.getExperiments());
        Platform[] platformArrValues = Platform.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            Platform platform = platformArrValues[i];
            if (platform.getEnabled() && (platform != Platform.PLAYSTATION || zCanSeePlaystationAccountIntegration)) {
                arrayList.add(platform);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new WidgetSettingsUserConnectionsAdd$PlatformItem((Platform) it.next()));
        }
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2613b;
        m.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
        WidgetSettingsUserConnectionsAdd$Adapter widgetSettingsUserConnectionsAdd$Adapter = (WidgetSettingsUserConnectionsAdd$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetSettingsUserConnectionsAdd$Adapter(recyclerView, new WidgetSettingsUserConnectionsAdd$onViewCreated$1(this)));
        this.adapter = widgetSettingsUserConnectionsAdd$Adapter;
        if (widgetSettingsUserConnectionsAdd$Adapter != null) {
            widgetSettingsUserConnectionsAdd$Adapter.setData(arrayList2);
        }
    }
}
