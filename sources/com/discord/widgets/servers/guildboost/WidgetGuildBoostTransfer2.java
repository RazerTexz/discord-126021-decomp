package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildBoostTransferBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.guildboost.GuildBoostConfirmationView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoostTransfer2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildBoostTransferBinding> {
    public static final WidgetGuildBoostTransfer2 INSTANCE = new WidgetGuildBoostTransfer2();

    public WidgetGuildBoostTransfer2() {
        super(1, WidgetGuildBoostTransferBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildBoostTransferBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.guild_boost_transfer_confirmation_blurb;
            TextView textView = (TextView) view.findViewById(R.id.guild_boost_transfer_confirmation_blurb);
            if (textView != null) {
                i = R.id.guild_boost_transfer_error;
                TextView textView2 = (TextView) view.findViewById(R.id.guild_boost_transfer_error);
                if (textView2 != null) {
                    i = R.id.guild_boost_transfer_previous_guild;
                    GuildBoostConfirmationView guildBoostConfirmationView = (GuildBoostConfirmationView) view.findViewById(R.id.guild_boost_transfer_previous_guild);
                    if (guildBoostConfirmationView != null) {
                        i = R.id.guild_boost_transfer_previous_guild_header;
                        TextView textView3 = (TextView) view.findViewById(R.id.guild_boost_transfer_previous_guild_header);
                        if (textView3 != null) {
                            i = R.id.guild_boost_transfer_select;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_boost_transfer_select);
                            if (materialButton != null) {
                                i = R.id.guild_boost_transfer_target_guild;
                                GuildBoostConfirmationView guildBoostConfirmationView2 = (GuildBoostConfirmationView) view.findViewById(R.id.guild_boost_transfer_target_guild);
                                if (guildBoostConfirmationView2 != null) {
                                    i = R.id.guild_boost_transfer_target_guild_header;
                                    TextView textView4 = (TextView) view.findViewById(R.id.guild_boost_transfer_target_guild_header);
                                    if (textView4 != null) {
                                        return new WidgetGuildBoostTransferBinding((CoordinatorLayout) view, dimmerView, textView, textView2, guildBoostConfirmationView, textView3, materialButton, guildBoostConfirmationView2, textView4);
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
}
