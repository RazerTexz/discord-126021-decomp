package com.discord.widgets.client;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetClientOutdatedBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetClientOutdated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClientOutdated extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetClientOutdated.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClientOutdatedBinding;", 0)};
    public static final WidgetClientOutdated$Companion Companion = new WidgetClientOutdated$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetClientOutdated() {
        super(R$layout.widget_client_outdated);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetClientOutdated$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetClientOutdatedBinding getBinding() {
        return (WidgetClientOutdatedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f2351b.setOnClickListener(WidgetClientOutdated$onViewCreated$1.INSTANCE);
        AppFragment.setOnBackPressed$default(this, WidgetClientOutdated$onViewCreated$2.INSTANCE, 0, 2, null);
    }
}
