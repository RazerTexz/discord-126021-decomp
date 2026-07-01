package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.a.z.a.a.a;
import b.a.z.a.a.b;
import b.a.z.a.a.c;
import b.a.z.a.a.n;
import b.a.z.a.a.o;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddMember extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;
    public static final /* synthetic */ int j = 0;
    private SimpleMembersAdapter membersAdapter;
    private RecyclerView membersRecycler;
    private final Subject<String, String> nameFilterPublisher;
    private TextInputLayout searchBox;
    private ViewFlipper viewFlipper;

    public WidgetChannelSettingsPermissionsAddMember() {
        super(R$layout.widget_channel_settings_permissions_add_member);
        this.nameFilterPublisher = BehaviorSubject.l0("");
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(2131886310);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private void configureUI(WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model) {
        if (widgetChannelSettingsPermissionsAddMember$Model == null || !WidgetChannelSettingsPermissionsAddMember$Model.access$000(widgetChannelSettingsPermissionsAddMember$Model)) {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        } else {
            configureToolbar(WidgetChannelSettingsPermissionsAddMember$Model.access$100(widgetChannelSettingsPermissionsAddMember$Model));
            this.membersAdapter.setData(WidgetChannelSettingsPermissionsAddMember$Model.access$200(widgetChannelSettingsPermissionsAddMember$Model), new c(this, widgetChannelSettingsPermissionsAddMember$Model));
            ViewFlipper viewFlipper = this.viewFlipper;
            if (viewFlipper != null) {
                viewFlipper.setDisplayedChild(WidgetChannelSettingsPermissionsAddMember$Model.access$200(widgetChannelSettingsPermissionsAddMember$Model).isEmpty() ? 1 : 0);
            }
        }
    }

    public static void create(Context context, long j2, long j3) {
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_GUILD_ID", j2);
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j3);
        j.d(context, WidgetChannelSettingsPermissionsAddMember.class, intent);
    }

    public static /* synthetic */ void g(WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember, WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model) {
        widgetChannelSettingsPermissionsAddMember.configureUI(widgetChannelSettingsPermissionsAddMember$Model);
    }

    public /* synthetic */ Unit h(Editable editable) {
        this.nameFilterPublisher.onNext(editable.toString());
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        this.membersRecycler = (RecyclerView) view.findViewById(R$id.channel_settings_permissions_add_member_recycler);
        this.searchBox = (TextInputLayout) view.findViewById(R$id.channel_settings_permissions_add_member_name_search);
        this.viewFlipper = (ViewFlipper) view.findViewById(R$id.channel_settings_permissions_add_member_view_flipper);
        setActionBarDisplayHomeAsUpEnabled();
        this.membersAdapter = (SimpleMembersAdapter) MGRecyclerAdapter.configure(new SimpleMembersAdapter(this.membersRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L);
        ViewExtensions.addBindedTextWatcher(this.searchBox, this, new n(this));
        this.nameFilterPublisher.onNext(ViewExtensions.getTextOrEmpty(this.searchBox));
        this.nameFilterPublisher.p(750L, TimeUnit.MILLISECONDS).y(o.j).k(b.a.d.o.e(new b(longExtra), getClass()));
        Observable<WidgetChannelSettingsPermissionsAddMember$Model> observable = WidgetChannelSettingsPermissionsAddMember$Model.get(longExtra, longExtra2, this.nameFilterPublisher);
        m.checkNotNullParameter(this, "appComponent");
        m.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.ui(observable, this, null).k(b.a.d.o.e(new a(this), getClass()));
    }
}
