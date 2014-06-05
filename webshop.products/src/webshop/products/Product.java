package webshop.products;

public class Product {

	private String _id;
	private String name;
	private String category;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [_id=" + _id + ", name=" + name + ", category="
				+ category + "]";
	}

}
