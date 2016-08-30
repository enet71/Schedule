package factory.concreteFactories;

import factory.FactoryDB;
import factory.abstractProducts.Create;
import factory.abstractProducts.Edit;
import factory.abstractProducts.Remove;
import factory.abstractProducts.Select;
import factory.products.audience.CreateAudience;
import factory.products.audience.EditAudience;
import factory.products.audience.RemoveAudience;
import factory.products.audience.SelectAudience;

public class FactoryAudience implements FactoryDB{
    public Create tableCreate() {
        return new CreateAudience();
    }

    public Edit tableEdit() {
        return new EditAudience();
    }

    public Remove tableRemove() {
        return new RemoveAudience();
    }

    public Select tableSelect() {
        return new SelectAudience();
    }
}
