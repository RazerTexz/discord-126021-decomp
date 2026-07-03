package com.discord.widgets.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAuthorizedAppsListItemBinding;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.widgets.settings.WidgetSettingsAuthorizedApps;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$adapter$1 extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder> {
    public final /* synthetic */ WidgetSettingsAuthorizedApps this$0;

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$adapter$1$1 */
    /* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
    public static final class C96381 extends AbstractC12240o implements Function1<ModelOAuth2Token, Unit> {
        public C96381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelOAuth2Token modelOAuth2Token) {
            invoke2(modelOAuth2Token);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelOAuth2Token modelOAuth2Token) {
            C12238m.checkNotNullParameter(modelOAuth2Token, "oath2Token");
            WidgetSettingsAuthorizedApps$adapter$1.this.this$0.deauthorizeApp(modelOAuth2Token.getId());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAuthorizedApps$adapter$1(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        super(2);
        this.this$0 = widgetSettingsAuthorizedApps;
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(layoutInflater, "layoutInflater");
        C12238m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_settings_authorized_apps_list_item, viewGroup, false);
        int i = C5419R.id.oauth_application_deauthorize_btn;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(C5419R.id.oauth_application_deauthorize_btn);
        if (appCompatImageView != null) {
            i = C5419R.id.oauth_application_description_label_tv;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.oauth_application_description_label_tv);
            if (textView != null) {
                i = C5419R.id.oauth_application_description_tv;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.oauth_application_description_tv);
                if (textView2 != null) {
                    i = C5419R.id.oauth_application_icon_iv;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.oauth_application_icon_iv);
                    if (simpleDraweeView != null) {
                        MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                        i = C5419R.id.oauth_application_name_tv;
                        TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.oauth_application_name_tv);
                        if (textView3 != null) {
                            i = C5419R.id.oauth_application_permissions_label_tv;
                            TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.oauth_application_permissions_label_tv);
                            if (textView4 != null) {
                                i = C5419R.id.oauth_application_permissions_rv;
                                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.oauth_application_permissions_rv);
                                if (recyclerView != null) {
                                    WidgetSettingsAuthorizedAppsListItemBinding widgetSettingsAuthorizedAppsListItemBinding = new WidgetSettingsAuthorizedAppsListItemBinding(materialCardView, appCompatImageView, textView, textView2, simpleDraweeView, materialCardView, textView3, textView4, recyclerView);
                                    C12238m.checkNotNullExpressionValue(widgetSettingsAuthorizedAppsListItemBinding, "WidgetSettingsAuthorized…tInflater, parent, false)");
                                    return new WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder(widgetSettingsAuthorizedAppsListItemBinding, new C96381());
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
