package factory;

import factory.abstractProducts.Create;
import factory.abstractProducts.Edit;
import factory.abstractProducts.Remove;
import factory.abstractProducts.Select;

public interface FactoryDB {
    Create tableCreate();

    Edit tableEdit();

    Remove tableRemove();

    Select tableSelect();
}
