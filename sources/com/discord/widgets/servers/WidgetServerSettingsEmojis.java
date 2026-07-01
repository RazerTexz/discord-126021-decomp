package com.discord.widgets.servers;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsEmojisBinding;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.restapi.RestAPIParams$PostGuildEmoji;
import com.discord.stores.StoreStream;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g0.t;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEmojis.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmojisBinding;", 0)};
    public static final WidgetServerSettingsEmojis$Companion Companion = new WidgetServerSettingsEmojis$Companion(null);
    private static final int EMOJI_MAX_FILESIZE_KB = 256;
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_CONTENT = 1;
    private WidgetServerSettingsEmojis$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final LoggingConfig loggingConfig;
    private Action1<String> uploadEmojiAction;

    public WidgetServerSettingsEmojis() {
        super(R$layout.widget_server_settings_emojis);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEmojis$binding$2.INSTANCE, null, 2, null);
        this.guildId = -1L;
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsEmojis$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEmojis widgetServerSettingsEmojis, WidgetServerSettingsEmojis$Model widgetServerSettingsEmojis$Model) {
        widgetServerSettingsEmojis.configureUI(widgetServerSettingsEmojis$Model);
    }

    public static final /* synthetic */ void access$launchEditScreen(WidgetServerSettingsEmojis widgetServerSettingsEmojis, View view, ModelEmojiGuild modelEmojiGuild) {
        widgetServerSettingsEmojis.launchEditScreen(view, modelEmojiGuild);
    }

    public static final /* synthetic */ void access$uploadEmoji(WidgetServerSettingsEmojis widgetServerSettingsEmojis, String str, String str2) {
        widgetServerSettingsEmojis.uploadEmoji(str, str2);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(2131888749);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(WidgetServerSettingsEmojis$Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        configureToolbar(model.getGuild().getName());
        List<WidgetServerSettingsEmojis$Item> items = model.getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        String defaultName = model.getDefaultName();
        if (defaultName == null || t.isBlank(defaultName)) {
            return;
        }
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.widgetServerSettingsEmojisViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        this.uploadEmojiAction = new WidgetServerSettingsEmojis$configureUI$1(this, model);
        WidgetServerSettingsEmojis$Adapter widgetServerSettingsEmojis$Adapter = this.adapter;
        if (widgetServerSettingsEmojis$Adapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetServerSettingsEmojis$Adapter.setData(model.getItems());
        WidgetServerSettingsEmojis$Adapter widgetServerSettingsEmojis$Adapter2 = this.adapter;
        if (widgetServerSettingsEmojis$Adapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetServerSettingsEmojis$Adapter2.setOnUploadEmoji(new WidgetServerSettingsEmojis$configureUI$2(this));
        WidgetServerSettingsEmojis$Adapter widgetServerSettingsEmojis$Adapter3 = this.adapter;
        if (widgetServerSettingsEmojis$Adapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetServerSettingsEmojis$Adapter3.setOnEmojiItemClicked(new WidgetServerSettingsEmojis$configureUI$3(this));
    }

    private final WidgetServerSettingsEmojisBinding getBinding() {
        return (WidgetServerSettingsEmojisBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void launchEditScreen(View v, ModelEmojiGuild emoji) {
        WidgetServerSettingsEmojisEdit$Companion widgetServerSettingsEmojisEdit$Companion = WidgetServerSettingsEmojisEdit.Companion;
        Context context = v.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        widgetServerSettingsEmojisEdit$Companion.create(context, this.guildId, emoji.getId(), emoji.getName());
    }

    private final void uploadEmoji(String name, String imageBase64) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().postGuildEmoji(this.guildId, new RestAPIParams$PostGuildEmoji(name, imageBase64)), false, 1, null), this, null, 2, null).k(o.i(WidgetServerSettingsEmojis$uploadEmoji$1.INSTANCE, this));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.uploadEmojiAction, ImageUploadDialog$PreviewType.EMOJI);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.uploadEmojiAction);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StoreStream.Companion.getGuildEmojis().deactivate();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.guildId = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2562b;
        m.checkNotNullExpressionValue(recyclerView, "binding.widgetServerSettingsEmojisRecycler");
        this.adapter = (WidgetServerSettingsEmojis$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsEmojis$Adapter(recyclerView));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion.getGuildEmojis().activate(this.guildId);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsEmojis$Model.Companion.get(this.guildId), this, null, 2, null), WidgetServerSettingsEmojis.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEmojis$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
