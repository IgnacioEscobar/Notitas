package notitas.ui.utils;

import notitas.model.Tarea;
import org.apache.commons.collections15.Transformer;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

public class TableBuilder<T> {
    private Table<T> table;
    private Column<T> lastColumn;

    public TableBuilder(Panel panel,Class<T> itemClass, String propertyToBind){
        table = new Table<>(panel, itemClass);
        table.bindItemsToProperty(propertyToBind);
    }

    public TableBuilder setNumberVisibleRows(int visibleRows){
        table.setNumberVisibleRows(visibleRows);
        return this;
    }

    public TableBuilder buildColumn(String title, String propertyToBind, int fixedSize ){
        buildColumn(title, fixedSize);
        lastColumn.bindContentsToProperty(propertyToBind);
        return this;
    }

    public TableBuilder buildColumn(String title, int fixedSize){
        Column<T> column = new Column<>(table);
        lastColumn = column;
        column.setTitle(title);
        column.setFixedSize(fixedSize);
        return this;
    }

    public TableBuilder bindToPropertyWithTransformer(String propertyToBind, Transformer transformer){
        lastColumn.bindContentsToProperty(propertyToBind).setTransformer(transformer);
        return this;
    }

}