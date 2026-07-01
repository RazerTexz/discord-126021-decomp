package com.lytefast.flexinput.adapters;

import android.os.AsyncTask;
import b.b.a.d.e;
import b.b.a.d.f;
import b.b.a.d.g;
import b.b.a.g.a;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.lytefast.flexinput.model.Attachment;
import d0.t.q;
import d0.t.r;
import d0.z.d.m;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter$a extends AsyncTask<File, Boolean, List<? extends Attachment<? extends File>>> {
    public final FileListAdapter a;

    public FileListAdapter$a(FileListAdapter fileListAdapter) {
        m.checkNotNullParameter(fileListAdapter, "adapter");
        this.a = fileListAdapter;
    }

    @Override // android.os.AsyncTask
    public List<? extends Attachment<? extends File>> doInBackground(File[] fileArr) {
        File[] fileArr2 = fileArr;
        m.checkNotNullParameter(fileArr2, "rootFiles");
        File file = fileArr2[0];
        g gVar = g.j;
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        r.addAll(linkedList, gVar.a(file));
        while (!linkedList.isEmpty()) {
            File file2 = (File) linkedList.remove();
            m.checkNotNullExpressionValue(file2, "file");
            if (!file2.isHidden()) {
                if (file2.isDirectory()) {
                    r.addAll(linkedList, gVar.a(file2));
                } else {
                    arrayList.add(a.a(file2));
                }
            }
        }
        q.sortWith(arrayList, d0.u.a.then(new f(this), new e()));
        return arrayList;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(List<? extends Attachment<? extends File>> list) {
        List<? extends Attachment<? extends File>> list2 = list;
        m.checkNotNullParameter(list2, ChatInputComponentTypes.FILES);
        FileListAdapter fileListAdapter = this.a;
        fileListAdapter.files = list2;
        fileListAdapter.notifyDataSetChanged();
    }
}
