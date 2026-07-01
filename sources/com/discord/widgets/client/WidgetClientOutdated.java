package com.discord.widgets.client;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetClientOutdatedBinding;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetClientOutdated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClientOutdated extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetClientOutdated.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClientOutdatedBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetClientOutdated.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetClientOutdated.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetClientOutdated() {
        super(R.layout.widget_client_outdated);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetClientOutdated2.INSTANCE, null, 2, null);
    }

    private final WidgetClientOutdatedBinding getBinding() {
        return (WidgetClientOutdatedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f2351b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.client.WidgetClientOutdated.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Intrinsics3.checkNotNullExpressionValue(view2, "v");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "v.context");
                UriHandler.directToPlayStore$default(context, null, null, 6, null);
            }
        });
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.client.WidgetClientOutdated.onViewCreated.2
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }
}
