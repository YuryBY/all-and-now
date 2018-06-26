package com.ybakhmutski.allandnow.pdi14470;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

/**
 * Created by Yury_Bakhmutski on 9/4/2017.
 */
public class DialogRunner {
    public static void main(String[] args) {
        openFile();
    }


    public static void openFile() {
        //try {
            //SpoonPerspective activePerspective = SpoonPerspectiveManager.getInstance().getActivePerspective();

            //String activePerspectiveId = activePerspective.getId();
            //boolean etlPerspective = activePerspectiveId.equals(MainSpoonPerspective.ID);


            Display display = Display.getDefault();
            FileDialog dialog = new FileDialog(display.getActiveShell(), SWT.OPEN);

            /*LinkedHashSet<String> extensions = new LinkedHashSet<>();
            LinkedHashSet<String> extensionNames = new LinkedHashSet<>();
            StringBuilder allExtensions = new StringBuilder();*/
            /*for (FileListener l : fileListeners) {
                for (String ext : l.getSupportedExtensions()) {
                    extensions.add("*." + ext);
                    allExtensions.append("*.").append(ext).append(";");
                }
                Collections.addAll(extensionNames, l.getFileTypeDisplayNames(Locale.getDefault()));
            }
            extensions.add("*");
            extensionNames.add(BaseMessages.getString(PKG, "Spoon.Dialog.OpenFile.AllFiles"));

            String[] exts = new String[extensions.size() + 1];
            exts[0] = allExtensions.toString();
            System.arraycopy(extensions.toArray(new String[extensions.size()]), 0, exts, 1, extensions.size());

            String[] extNames = new String[extensionNames.size() + 1];
            extNames[0] = BaseMessages.getString(PKG, "Spoon.Dialog.OpenFile.AllTypes");
            System.arraycopy(extensionNames.toArray(new String[extensionNames.size()]), 0, extNames, 1, extensionNames
                    .size());

            dialog.setFilterExtensions(exts);

            setFilterPath(dialog);*/
            String filename = dialog.open();
            /*if (filename != null) {

                if (importfile) {
                    if (activePerspective instanceof SpoonPerspectiveOpenSaveInterface) {
                        ((SpoonPerspectiveOpenSaveInterface) activePerspective).importFile(filename);
                        return;
                    }
                }

                lastDirOpened = dialog.getFilterPath();
                openFile(filename, importfile);
            }

        } catch (KettleRepositoryLostException krle) {
            new ErrorDialog(
                    getShell(),
                    BaseMessages.getString(PKG, "Spoon.Error"),
                    krle.getPrefaceMessage(),
                    krle);
            this.closeRepository();
        }*/
        }
}
