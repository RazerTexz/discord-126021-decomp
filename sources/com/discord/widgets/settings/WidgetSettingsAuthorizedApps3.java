package com.discord.widgets.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAuthorizedAppsListItemBinding;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.widgets.settings.WidgetSettingsAuthorizedApps;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps3 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder> {
    public final /* synthetic */ WidgetSettingsAuthorizedApps this$0;

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$adapter$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelOAuth2Token, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelOAuth2Token modelOAuth2Token) {
            invoke2(modelOAuth2Token);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelOAuth2Token modelOAuth2Token) {
            Intrinsics3.checkNotNullParameter(modelOAuth2Token, "oath2Token");
            WidgetSettingsAuthorizedApps3.this.this$0.deauthorizeApp(modelOAuth2Token.getId());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAuthorizedApps3(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        super(2);
        this.this$0 = widgetSettingsAuthorizedApps;
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R.layout.widget_settings_authorized_apps_list_item, viewGroup, false);
        int i = R.id.oauth_application_deauthorize_btn;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.oauth_application_deauthorize_btn);
        if (appCompatImageView != null) {
            i = R.id.oauth_application_description_label_tv;
            TextView textView = (TextView) viewInflate.findViewById(R.id.oauth_application_description_label_tv);
            if (textView != null) {
                i = R.id.oauth_application_description_tv;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.oauth_application_description_tv);
                if (textView2 != null) {
                    i = R.id.oauth_application_icon_iv;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.oauth_application_icon_iv);
                    if (simpleDraweeView != null) {
                        MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                        i = R.id.oauth_application_name_tv;
                        TextView textView3 = (TextView) viewInflate.findViewById(R.id.oauth_application_name_tv);
                        if (textView3 != null) {
                            i = R.id.oauth_application_permissions_label_tv;
                            TextView textView4 = (TextView) viewInflate.findViewById(R.id.oauth_application_permissions_label_tv);
                            if (textView4 != null) {
                                i = R.id.oauth_application_permissions_rv;
                                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.oauth_application_permissions_rv);
                                if (recyclerView != null) {
                                    WidgetSettingsAuthorizedAppsListItemBinding widgetSettingsAuthorizedAppsListItemBinding = new WidgetSettingsAuthorizedAppsListItemBinding(materialCardView, appCompatImageView, textView, textView2, simpleDraweeView, materialCardView, textView3, textView4, recyclerView);
                                    Intrinsics3.checkNotNullExpressionValue(widgetSettingsAuthorizedAppsListItemBinding, "WidgetSettingsAuthorized…tInflater, parent, false)");
                                    return new WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder(widgetSettingsAuthorizedAppsListItemBinding, new AnonymousClass1());
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
