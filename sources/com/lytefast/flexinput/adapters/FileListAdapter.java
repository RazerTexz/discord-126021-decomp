package com.lytefast.flexinput.adapters;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.d.FileListAdapter2;
import b.b.a.d.e;
import b.b.a.d.f;
import b.b.a.g.FileUtils;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.t.MutableCollectionsJVM;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final SelectionCoordinator<?, ? super Attachment<? extends File>> selectionCoordinator;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public List<? extends Attachment<? extends File>> files;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final ContentResolver contentResolver;

    /* JADX INFO: compiled from: FileListAdapter.kt */
    public static final class a extends AsyncTask<File, Boolean, List<? extends Attachment<? extends File>>> {
        public final FileListAdapter a;

        public a(FileListAdapter fileListAdapter) {
            Intrinsics3.checkNotNullParameter(fileListAdapter, "adapter");
            this.a = fileListAdapter;
        }

        @Override // android.os.AsyncTask
        public List<? extends Attachment<? extends File>> doInBackground(File[] fileArr) {
            File[] fileArr2 = fileArr;
            Intrinsics3.checkNotNullParameter(fileArr2, "rootFiles");
            File file = fileArr2[0];
            FileListAdapter2 fileListAdapter2 = FileListAdapter2.j;
            ArrayList arrayList = new ArrayList();
            LinkedList linkedList = new LinkedList();
            MutableCollections.addAll(linkedList, fileListAdapter2.invoke(file));
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.remove();
                Intrinsics3.checkNotNullExpressionValue(file2, "file");
                if (!file2.isHidden()) {
                    if (file2.isDirectory()) {
                        MutableCollections.addAll(linkedList, fileListAdapter2.invoke(file2));
                    } else {
                        arrayList.add(FileUtils.a(file2));
                    }
                }
            }
            MutableCollectionsJVM.sortWith(arrayList, d0.u.a.then(new f(this), new e()));
            return arrayList;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(List<? extends Attachment<? extends File>> list) {
            List<? extends Attachment<? extends File>> list2 = list;
            Intrinsics3.checkNotNullParameter(list2, ChatInputComponentTypes.FILES);
            FileListAdapter fileListAdapter = this.a;
            fileListAdapter.files = list2;
            fileListAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: FileListAdapter.kt */
    public class b extends RecyclerView.ViewHolder {
        public final AnimatorSet a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AnimatorSet f3162b;
        public SimpleDraweeView c;
        public ImageView d;
        public TextView e;
        public TextView f;
        public Attachment<? extends File> g;
        public final /* synthetic */ FileListAdapter h;

        /* JADX INFO: compiled from: FileListAdapter.kt */
        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z2;
                b bVar = b.this;
                SelectionCoordinator<?, ? super Attachment<? extends File>> selectionCoordinator = bVar.h.selectionCoordinator;
                Attachment<? extends File> attachment = bVar.g;
                int adapterPosition = bVar.getAdapterPosition();
                Objects.requireNonNull(selectionCoordinator);
                if (attachment == null || selectionCoordinator.d(attachment)) {
                    z2 = false;
                } else {
                    selectionCoordinator.c(attachment, adapterPosition);
                    z2 = true;
                }
                bVar.b(z2, true);
            }
        }

        /* JADX INFO: renamed from: com.lytefast.flexinput.adapters.FileListAdapter$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileListAdapter.kt */
        public static final class C0368b extends Lambda implements Function1<AnimatorSet, Unit> {
            public final /* synthetic */ boolean $isAnimationRequested;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0368b(boolean z2) {
                super(1);
                this.$isAnimationRequested = z2;
            }

            public final void a(AnimatorSet animatorSet) {
                Intrinsics3.checkNotNullParameter(animatorSet, "animation");
                animatorSet.start();
                if (this.$isAnimationRequested) {
                    return;
                }
                animatorSet.end();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimatorSet animatorSet) {
                a(animatorSet);
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FileListAdapter fileListAdapter, View view) {
            super(view);
            Intrinsics3.checkNotNullParameter(view, "itemView");
            this.h = fileListAdapter;
            View viewFindViewById = view.findViewById(R.f.thumb_iv);
            Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.thumb_iv)");
            this.c = (SimpleDraweeView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.f.type_iv);
            Intrinsics3.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.type_iv)");
            this.d = (ImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.f.file_name_tv);
            Intrinsics3.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.id.file_name_tv)");
            this.e = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.f.file_subtitle_tv);
            Intrinsics3.checkNotNullExpressionValue(viewFindViewById4, "itemView.findViewById(R.id.file_subtitle_tv)");
            this.f = (TextView) viewFindViewById4;
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "this.itemView");
            view2.setClickable(true);
            this.itemView.setOnClickListener(new a());
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(view.getContext(), R.a.selection_shrink);
            Objects.requireNonNull(animatorLoadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
            this.a = animatorSet;
            animatorSet.setTarget(this.c);
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(view.getContext(), R.a.selection_grow);
            Objects.requireNonNull(animatorLoadAnimator2, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
            this.f3162b = animatorSet2;
            animatorSet2.setTarget(this.c);
        }

        public final void a(File file) throws IOException {
            Bitmap thumbnail;
            Cursor cursorQuery = this.h.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "mini_thumb_magic"}, "_data=?", new String[]{file.getPath()}, null);
            if (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Closeable.closeFinally(cursorQuery, null);
                        return;
                    }
                    long j = cursorQuery.getLong(0);
                    if (cursorQuery.getLong(1) == 0 && (thumbnail = MediaStore.Images.Thumbnails.getThumbnail(this.h.contentResolver, j, 1, null)) != null) {
                        thumbnail.recycle();
                    }
                    Cursor cursorQuery2 = this.h.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "image_id=?", new String[]{String.valueOf(j)}, null);
                    if (cursorQuery2 != null) {
                        try {
                            if (!cursorQuery2.moveToFirst()) {
                                Closeable.closeFinally(cursorQuery2, null);
                                Closeable.closeFinally(cursorQuery, null);
                                return;
                            }
                            String string = cursorQuery2.getString(0);
                            SimpleDraweeView simpleDraweeView = this.c;
                            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
                            pipelineDraweeControllerBuilderA.n = this.c.getController();
                            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderF = pipelineDraweeControllerBuilderA.f(Uri.withAppendedPath(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, string));
                            pipelineDraweeControllerBuilderF.l = true;
                            simpleDraweeView.setController(pipelineDraweeControllerBuilderF.a());
                            Closeable.closeFinally(cursorQuery2, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                Closeable.closeFinally(cursorQuery2, th);
                                throw th2;
                            }
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            Closeable.closeFinally(cursorQuery, th);
                            throw th3;
                        }
                    }
                    Closeable.closeFinally(cursorQuery, null);
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }

        public final void b(boolean z2, boolean z3) {
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            view.setSelected(z2);
            C0368b c0368b = new C0368b(z3);
            if (z2) {
                if (this.c.getScaleX() == 1.0f) {
                    c0368b.a(this.a);
                }
            } else if (this.c.getScaleX() != 1.0f) {
                c0368b.a(this.f3162b);
            }
        }
    }

    public FileListAdapter(ContentResolver contentResolver, SelectionCoordinator<?, Attachment<File>> selectionCoordinator) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        this.contentResolver = contentResolver;
        Objects.requireNonNull(selectionCoordinator);
        Intrinsics3.checkNotNullParameter(this, "adapter");
        selectionCoordinator.adapter = this;
        this.selectionCoordinator = selectionCoordinator;
        this.files = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.files.size();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00e1  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws IOException {
        String mimeTypeFromExtension;
        String str;
        b bVar = (b) viewHolder;
        Intrinsics3.checkNotNullParameter(bVar, "holder");
        Attachment<? extends File> attachment = this.files.get(i);
        Objects.requireNonNull(bVar);
        Intrinsics3.checkNotNullParameter(attachment, "fileAttachment");
        bVar.g = attachment;
        bVar.b(bVar.h.selectionCoordinator.a(attachment, bVar.getAdapterPosition()), false);
        File data = attachment.getData();
        if (data != null) {
            bVar.e.setText(data.getName());
            TextView textView = bVar.f;
            Intrinsics3.checkNotNullParameter(data, "$this$getFileSize");
            long j = 1024;
            long length = data.length() / j;
            if (length < j) {
                str = length + " KB";
            } else {
                long j2 = length / j;
                if (j2 < j) {
                    str = j2 + " MB";
                } else {
                    str = (j2 / j) + " GB";
                }
            }
            textView.setText(str);
        } else {
            bVar.e.setText((CharSequence) null);
            bVar.f.setText((CharSequence) null);
        }
        SimpleDraweeView simpleDraweeView = bVar.c;
        simpleDraweeView.setImageURI((Uri) null, simpleDraweeView.getContext());
        bVar.d.setVisibility(8);
        boolean z2 = true;
        if (data != null) {
            Objects.requireNonNull(bVar.h);
            String name = data.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "fileName");
            int iLastIndexOf$default = Strings4.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null) + 1;
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = name.substring(iLastIndexOf$default);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            if (TextUtils.isEmpty(strSubstring)) {
                mimeTypeFromExtension = null;
            } else {
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strSubstring);
            }
        } else {
            mimeTypeFromExtension = null;
        }
        if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        bVar.c.setImageURI(Uri.fromFile(data), bVar.c.getContext());
        if (StringsJVM.startsWith$default(mimeTypeFromExtension, "image", false, 2, null)) {
            ImageView imageView = bVar.d;
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView, R.b.ic_flex_input_image, 0, 2, (Object) null));
            bVar.d.setVisibility(0);
            bVar.a(data);
            return;
        }
        if (StringsJVM.startsWith$default(mimeTypeFromExtension, MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null)) {
            ImageView imageView2 = bVar.d;
            imageView2.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView2, R.b.ic_flex_input_movie, 0, 2, (Object) null));
            bVar.d.setVisibility(0);
            bVar.a(data);
            return;
        }
        if (StringsJVM.startsWith$default(mimeTypeFromExtension, MediaStreamTrack.AUDIO_TRACK_KIND, false, 2, null)) {
            ImageView imageView3 = bVar.d;
            imageView3.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView3, R.b.ic_flex_input_audio, 0, 2, (Object) null));
            bVar.d.setVisibility(0);
            bVar.a(data);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.g.view_file_item, viewGroup, false);
        Intrinsics3.checkNotNullExpressionValue(viewInflate, "view");
        return new b(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        Object next;
        b bVar = (b) viewHolder;
        Intrinsics3.checkNotNullParameter(bVar, "holder");
        Intrinsics3.checkNotNullParameter(list, "payloads");
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof SelectionCoordinator.a));
        if (next != null) {
            SelectionCoordinator.a aVar = (SelectionCoordinator.a) (next instanceof SelectionCoordinator.a ? next : null);
            if (aVar != null) {
                bVar.b(aVar.f3171b, true);
                return;
            }
        }
        super.onBindViewHolder(bVar, i, list);
    }
}
