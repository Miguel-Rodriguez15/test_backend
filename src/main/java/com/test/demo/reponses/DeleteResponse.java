package com.test.demo.reponses;

public class DeleteResponse {
  private String message;
  private Long branchId;

  public DeleteResponse(String message, Long branchId) {
      this.message = message;
      this.branchId = branchId;
  }

  public String getMessage() {
      return message;
  }

  public void setMessage(String message) {
      this.message = message;
  }

  public Long getBranchId() {
      return branchId;
  }

  public void setBranchId(Long branchId) {
      this.branchId = branchId;
  }
}