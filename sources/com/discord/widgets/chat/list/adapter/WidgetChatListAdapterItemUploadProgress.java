package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.WidgetChatListAdapterItemUploadProgressBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.file.FileUtilsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.UploadProgressView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.UploadProgressEntry;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress extends WidgetChatListItem {
    public static final WidgetChatListAdapterItemUploadProgress$Companion Companion = new WidgetChatListAdapterItemUploadProgress$Companion(null);
    private static final long MODEL_THROTTLE_MS = 100;
    private final WidgetChatListAdapterItemUploadProgressBinding binding;
    private Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_upload_progress, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.progress_cancel_centered;
        ImageView imageView = (ImageView) view.findViewById(R$id.progress_cancel_centered);
        if (imageView != null) {
            i = R$id.progress_cancel_top;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.progress_cancel_top);
            if (imageView2 != null) {
                i = R$id.upload_progress_1;
                UploadProgressView uploadProgressView = (UploadProgressView) view.findViewById(R$id.upload_progress_1);
                if (uploadProgressView != null) {
                    i = R$id.upload_progress_2;
                    UploadProgressView uploadProgressView2 = (UploadProgressView) view.findViewById(R$id.upload_progress_2);
                    if (uploadProgressView2 != null) {
                        i = R$id.upload_progress_3;
                        UploadProgressView uploadProgressView3 = (UploadProgressView) view.findViewById(R$id.upload_progress_3);
                        if (uploadProgressView3 != null) {
                            WidgetChatListAdapterItemUploadProgressBinding widgetChatListAdapterItemUploadProgressBinding = new WidgetChatListAdapterItemUploadProgressBinding((LinearLayout) view, imageView, imageView2, uploadProgressView, uploadProgressView2, uploadProgressView3);
                            m.checkNotNullExpressionValue(widgetChatListAdapterItemUploadProgressBinding, "WidgetChatListAdapterIte…essBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemUploadProgressBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress, WidgetChatListAdapterItemUploadProgress$Model widgetChatListAdapterItemUploadProgress$Model) {
        widgetChatListAdapterItemUploadProgress.configureUI(widgetChatListAdapterItemUploadProgress$Model);
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress) {
        return widgetChatListAdapterItemUploadProgress.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress, Subscription subscription) {
        widgetChatListAdapterItemUploadProgress.subscription = subscription;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ec  */
    private final void configureUI(WidgetChatListAdapterItemUploadProgress$Model uploadState) {
        boolean z2;
        boolean z3;
        boolean z4 = uploadState instanceof WidgetChatListAdapterItemUploadProgress$Model$Few;
        if (z4) {
            UploadProgressView uploadProgressView = this.binding.d;
            m.checkNotNullExpressionValue(uploadProgressView, "binding.uploadProgress1");
            WidgetChatListAdapterItemUploadProgress$Model$Few widgetChatListAdapterItemUploadProgress$Model$Few = (WidgetChatListAdapterItemUploadProgress$Model$Few) uploadState;
            setUploadState(uploadProgressView, widgetChatListAdapterItemUploadProgress$Model$Few.getUploads().get(0));
            UploadProgressView uploadProgressView2 = this.binding.e;
            m.checkNotNullExpressionValue(uploadProgressView2, "binding.uploadProgress2");
            setUploadState(uploadProgressView2, widgetChatListAdapterItemUploadProgress$Model$Few.getUploads().get(1));
            UploadProgressView uploadProgressView3 = this.binding.f;
            m.checkNotNullExpressionValue(uploadProgressView3, "binding.uploadProgress3");
            uploadProgressView3.setVisibility(0);
            if (widgetChatListAdapterItemUploadProgress$Model$Few.getUploads().size() == 3) {
                UploadProgressView uploadProgressView4 = this.binding.f;
                m.checkNotNullExpressionValue(uploadProgressView4, "binding.uploadProgress3");
                uploadProgressView4.setVisibility(0);
                UploadProgressView uploadProgressView5 = this.binding.f;
                m.checkNotNullExpressionValue(uploadProgressView5, "binding.uploadProgress3");
                setUploadState(uploadProgressView5, widgetChatListAdapterItemUploadProgress$Model$Few.getUploads().get(2));
            } else {
                UploadProgressView uploadProgressView6 = this.binding.f;
                m.checkNotNullExpressionValue(uploadProgressView6, "binding.uploadProgress3");
                uploadProgressView6.setVisibility(8);
            }
        } else {
            UploadProgressView uploadProgressView7 = this.binding.d;
            m.checkNotNullExpressionValue(uploadProgressView7, "binding.uploadProgress1");
            setUploadState(uploadProgressView7, uploadState);
            UploadProgressView uploadProgressView8 = this.binding.e;
            m.checkNotNullExpressionValue(uploadProgressView8, "binding.uploadProgress2");
            uploadProgressView8.setVisibility(8);
            UploadProgressView uploadProgressView9 = this.binding.f;
            m.checkNotNullExpressionValue(uploadProgressView9, "binding.uploadProgress3");
            uploadProgressView9.setVisibility(8);
        }
        if ((uploadState instanceof WidgetChatListAdapterItemUploadProgress$Model$Preprocessing) || ((uploadState instanceof WidgetChatListAdapterItemUploadProgress$Model$Single) && ((WidgetChatListAdapterItemUploadProgress$Model$Single) uploadState).getProgress() < 100)) {
            z2 = true;
        } else if (z4) {
            List<WidgetChatListAdapterItemUploadProgress$Model$Single> uploads = ((WidgetChatListAdapterItemUploadProgress$Model$Few) uploadState).getUploads();
            if (!(uploads instanceof Collection) || !uploads.isEmpty()) {
                Iterator<T> it = uploads.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else {
                        if (((WidgetChatListAdapterItemUploadProgress$Model$Single) it.next()).getProgress() < 100) {
                            z3 = true;
                            break;
                        }
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3) {
                z2 = true;
            } else if ((uploadState instanceof WidgetChatListAdapterItemUploadProgress$Model$Many) || ((WidgetChatListAdapterItemUploadProgress$Model$Many) uploadState).getProgress() >= 100) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            if (uploadState instanceof WidgetChatListAdapterItemUploadProgress$Model$Many) {
            }
            z2 = false;
        }
        if (z2) {
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.progressCancelTop");
            imageView.setVisibility(z4 ? 0 : 8);
            ImageView imageView2 = this.binding.f2342b;
            m.checkNotNullExpressionValue(imageView2, "binding.progressCancelCentered");
            imageView2.setVisibility(z4 ^ true ? 0 : 8);
            return;
        }
        ImageView imageView3 = this.binding.c;
        m.checkNotNullExpressionValue(imageView3, "binding.progressCancelTop");
        imageView3.setVisibility(8);
        ImageView imageView4 = this.binding.f2342b;
        m.checkNotNullExpressionValue(imageView4, "binding.progressCancelCentered");
        imageView4.setVisibility(8);
    }

    private final void setUploadState(UploadProgressView uploadProgressView, WidgetChatListAdapterItemUploadProgress$Model widgetChatListAdapterItemUploadProgress$Model) {
        if (m.areEqual(widgetChatListAdapterItemUploadProgress$Model, WidgetChatListAdapterItemUploadProgress$Model$None.INSTANCE)) {
            CharSequence charSequenceJ = b.j(uploadProgressView, 2131896682, new Object[0], null, 4);
            int i = UploadProgressView.j;
            uploadProgressView.a(charSequenceJ, 0, null);
            Context context = uploadProgressView.getContext();
            m.checkNotNullExpressionValue(context, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context, 2130969555, 0, 2, (Object) null));
            return;
        }
        if (widgetChatListAdapterItemUploadProgress$Model instanceof WidgetChatListAdapterItemUploadProgress$Model$Preprocessing) {
            WidgetChatListAdapterItemUploadProgress$Model$Preprocessing widgetChatListAdapterItemUploadProgress$Model$Preprocessing = (WidgetChatListAdapterItemUploadProgress$Model$Preprocessing) widgetChatListAdapterItemUploadProgress$Model;
            CharSequence displayName = widgetChatListAdapterItemUploadProgress$Model$Preprocessing.getDisplayName();
            if (displayName == null) {
                Resources resources = uploadProgressView.getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                Context context2 = uploadProgressView.getContext();
                m.checkNotNullExpressionValue(context2, "context");
                displayName = StringResourceUtilsKt.getQuantityString(resources, context2, R$plurals.uploading_files_count, widgetChatListAdapterItemUploadProgress$Model$Preprocessing.getNumFiles(), Integer.valueOf(widgetChatListAdapterItemUploadProgress$Model$Preprocessing.getNumFiles()));
            }
            int i2 = UploadProgressView.j;
            uploadProgressView.a(displayName, -1, null);
            if (widgetChatListAdapterItemUploadProgress$Model$Preprocessing.getMimeType() != null) {
                Context context3 = uploadProgressView.getContext();
                m.checkNotNullExpressionValue(context3, "context");
                uploadProgressView.setIcon(FileUtilsKt.getIconForFiletype(context3, widgetChatListAdapterItemUploadProgress$Model$Preprocessing.getMimeType()));
                return;
            } else {
                Context context4 = uploadProgressView.getContext();
                m.checkNotNullExpressionValue(context4, "context");
                uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context4, 2130969555, 0, 2, (Object) null));
                return;
            }
        }
        if (widgetChatListAdapterItemUploadProgress$Model instanceof WidgetChatListAdapterItemUploadProgress$Model$Single) {
            WidgetChatListAdapterItemUploadProgress$Model$Single widgetChatListAdapterItemUploadProgress$Model$Single = (WidgetChatListAdapterItemUploadProgress$Model$Single) widgetChatListAdapterItemUploadProgress$Model;
            uploadProgressView.a(widgetChatListAdapterItemUploadProgress$Model$Single.getName(), widgetChatListAdapterItemUploadProgress$Model$Single.getProgress() != -1 ? widgetChatListAdapterItemUploadProgress$Model$Single.getProgress() : -1, FileUtilsKt.getSizeSubtitle(widgetChatListAdapterItemUploadProgress$Model$Single.getSizeBytes()));
            Context context5 = uploadProgressView.getContext();
            m.checkNotNullExpressionValue(context5, "context");
            uploadProgressView.setIcon(FileUtilsKt.getIconForFiletype(context5, widgetChatListAdapterItemUploadProgress$Model$Single.getMimeType()));
            return;
        }
        if (widgetChatListAdapterItemUploadProgress$Model instanceof WidgetChatListAdapterItemUploadProgress$Model$Many) {
            Resources resources2 = uploadProgressView.getResources();
            m.checkNotNullExpressionValue(resources2, "resources");
            Context context6 = uploadProgressView.getContext();
            m.checkNotNullExpressionValue(context6, "context");
            WidgetChatListAdapterItemUploadProgress$Model$Many widgetChatListAdapterItemUploadProgress$Model$Many = (WidgetChatListAdapterItemUploadProgress$Model$Many) widgetChatListAdapterItemUploadProgress$Model;
            uploadProgressView.a(StringResourceUtilsKt.getQuantityString(resources2, context6, R$plurals.uploading_files_count, widgetChatListAdapterItemUploadProgress$Model$Many.getNumFiles(), Integer.valueOf(widgetChatListAdapterItemUploadProgress$Model$Many.getNumFiles())), widgetChatListAdapterItemUploadProgress$Model$Many.getProgress() != -1 ? widgetChatListAdapterItemUploadProgress$Model$Many.getProgress() : -1, FileUtilsKt.getSizeSubtitle(widgetChatListAdapterItemUploadProgress$Model$Many.getSizeBytes()));
            Context context7 = uploadProgressView.getContext();
            m.checkNotNullExpressionValue(context7, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context7, 2130969555, 0, 2, (Object) null));
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        Observable<? extends WidgetChatListAdapterItemUploadProgress$Model> observableL = WidgetChatListAdapterItemUploadProgress$ModelProvider.INSTANCE.get(((UploadProgressEntry) data).getMessageNonce(), 100L).L();
        m.checkNotNullExpressionValue(observableL, "ModelProvider.get(data.m…  .onBackpressureLatest()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableL), WidgetChatListAdapterItemUploadProgress.class, (Context) null, new WidgetChatListAdapterItemUploadProgress$onConfigure$2(this), (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterItemUploadProgress$onConfigure$1(this), 58, (Object) null);
        WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 = new WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1(data);
        this.binding.c.setOnClickListener(new WidgetChatListAdapterItemUploadProgress$onConfigure$3(widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1));
        this.binding.f2342b.setOnClickListener(new WidgetChatListAdapterItemUploadProgress$onConfigure$4(widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1));
    }
}
