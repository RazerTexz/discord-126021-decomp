package com.discord.widgets.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetSettingsAuthorizedAppsListItemBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$adapter$1 extends o implements Function2<LayoutInflater, ViewGroup, WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder> {
    public final /* synthetic */ WidgetSettingsAuthorizedApps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAuthorizedApps$adapter$1(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        super(2);
        this.this$0 = widgetSettingsAuthorizedApps;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m.checkNotNullParameter(layoutInflater, "layoutInflater");
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R$layout.widget_settings_authorized_apps_list_item, viewGroup, false);
        int i = R$id.oauth_application_deauthorize_btn;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R$id.oauth_application_deauthorize_btn);
        if (appCompatImageView != null) {
            i = R$id.oauth_application_description_label_tv;
            TextView textView = (TextView) viewInflate.findViewById(R$id.oauth_application_description_label_tv);
            if (textView != null) {
                i = R$id.oauth_application_description_tv;
                TextView textView2 = (TextView) viewInflate.findViewById(R$id.oauth_application_description_tv);
                if (textView2 != null) {
                    i = R$id.oauth_application_icon_iv;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.oauth_application_icon_iv);
                    if (simpleDraweeView != null) {
                        MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                        i = R$id.oauth_application_name_tv;
                        TextView textView3 = (TextView) viewInflate.findViewById(R$id.oauth_application_name_tv);
                        if (textView3 != null) {
                            i = R$id.oauth_application_permissions_label_tv;
                            TextView textView4 = (TextView) viewInflate.findViewById(R$id.oauth_application_permissions_label_tv);
                            if (textView4 != null) {
                                i = R$id.oauth_application_permissions_rv;
                                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.oauth_application_permissions_rv);
                                if (recyclerView != null) {
                                    WidgetSettingsAuthorizedAppsListItemBinding widgetSettingsAuthorizedAppsListItemBinding = new WidgetSettingsAuthorizedAppsListItemBinding(materialCardView, appCompatImageView, textView, textView2, simpleDraweeView, materialCardView, textView3, textView4, recyclerView);
                                    m.checkNotNullExpressionValue(widgetSettingsAuthorizedAppsListItemBinding, "WidgetSettingsAuthorized…tInflater, parent, false)");
                                    return new WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder(widgetSettingsAuthorizedAppsListItemBinding, new WidgetSettingsAuthorizedApps$adapter$1$1(this));
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
